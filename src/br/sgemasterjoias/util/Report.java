package br.sgemasterjoias.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class Report {
	private String dataSource;
	private String folder;
	private String file;
	private StreamedContent pdf;
	
	public Report(String dataSource,String folder, String file) {
		this.dataSource = dataSource;
		this.folder = folder;
		this.file = file;
	}
	
	public StreamedContent getPdf() {
		try {
			build();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return pdf;
	}

	private void build() throws UtilException {
		
		@SuppressWarnings("rawtypes")
		HashMap parameters = null;
		
		try {
			Connection con = getConnection();
			FacesContext contextoFaces = FacesContext.getCurrentInstance();
			ExternalContext contextoExterno = contextoFaces.getExternalContext();
			ServletContext contextoServlet = (ServletContext) contextoExterno.getContext();

			String relPath = contextoServlet.getRealPath(File.separator+folder);
			String relArcPath = relPath + File.separator + file;

			InputStream resourceStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(folder + File.separator + file + ".jrxml");
			JasperDesign jasperDesign = JRXmlLoader.load(resourceStream);

			// compila o relatório
			JasperReport relatorioJasper = JasperCompileManager.compileReport(jasperDesign);
			
			@SuppressWarnings("unchecked")
			JasperPrint impressoraJasper = JasperFillManager.fillReport(relatorioJasper, parameters, con);

			String extension = null;
			File generatedFile = null;

			JRPdfExporter pdfExportado = new JRPdfExporter();
			extension = "pdf";
			generatedFile = new java.io.File(relArcPath + "." + extension);
			pdfExportado.setExporterInput(new SimpleExporterInput(impressoraJasper));
			pdfExportado.setExporterOutput(new SimpleOutputStreamExporterOutput(generatedFile));
			pdfExportado.exportReport();
			generatedFile.deleteOnExit();

			InputStream conteudoRelatorio = new FileInputStream(generatedFile);
			pdf = new DefaultStreamedContent(conteudoRelatorio, "application/" + extension,	file + "." + extension);
		} catch (JRException e) {
			throw new UtilException("Não foi possível gerar o relatório.", e);
		} catch (FileNotFoundException e) {
			throw new UtilException("Arquivo do relatório não encontrado.", e);
		}
	}

	private Connection getConnection() throws UtilException {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env/");
			javax.sql.DataSource ds = (javax.sql.DataSource) envContext.lookup(dataSource);
			return (java.sql.Connection) ds.getConnection();
		} catch (NamingException e) {
			throw new UtilException("Não foi possível encontrar o nome da conexão do banco.", e);
		} catch (SQLException e) {
			throw new UtilException("Ocorreu um erro de SQL.", e);
		}
	}

}