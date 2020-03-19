package com.wizen.infrastructure.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.ServletContextAware;




/**
 * Allows extraction of contents of a JAR file. All files matching a given Ant path pattern will be extracted into a
 * specified path.
 * Copied from http://stackoverflow.com/questions/5013917/can-i-serve-jsps-from-inside-a-jar-in-lib-or-is-there-a-workaround
 */

public class JarFileResourcesExtractor implements ServletContextAware {

    //private final transient Location logger = Location.getLocation(JarFileResourcesExtractor.class);
	private Log logger; 

    private String resourcePathPattern;
    private String jarFile;
    private String destination;
    private ServletContext servletContext;
    private AntPathMatcher pathMatcher = new AntPathMatcher();
    private List<File> listOfCopiedFiles = new ArrayList<File>();

    /**
     * Creates a new instance of the JarFileResourcesExtractor
     * 
     * @param resourcePathPattern
     *            The Ant style path pattern (supports wildcards) of the resources files to extract
     * @param jarFile
     *            The jar file (located inside WEB-INF/lib) to search for resources
     * @param destination
     *            Target folder of the extracted resources. Relative to the context.
     */
    public JarFileResourcesExtractor(String resourcePathPattern, String jarFile, String destination) {
    	this.logger = LogFactory.getLog(getClass());
        this.resourcePathPattern = resourcePathPattern;
        this.jarFile = jarFile;
        this.destination = destination;
        
        logger.info("resourcePathPattern = " + resourcePathPattern);
        logger.info("jarFile = " + jarFile);
        logger.info("destination = " + destination);
    }
    
    /*
    @Bean 
    public JarFileResourcesExtractor jspSupport(){
        final JarFileResourcesExtractor extractor = new JarFileResourcesExtractor("META-INF/resources","wizensoft-library-infrastructure.jar","WEB-INF/dest/wizensoft-library-infrastructure" );
        return extractor;
    }
    */


    @PreDestroy
    public void removeAddedFiles() throws IOException{
        logger.debug("I removeAddedFiles()");
        for (File fileToRemove : listOfCopiedFiles) {
            if(fileToRemove.delete()){
                logger.debug("Tagit bort filen " + fileToRemove.getAbsolutePath());
            }
        }
    }


    /** 
     * Extracts the resource files found in the specified jar file into the destination path
     * 
     * @throws IOException
     *             If an IO error occurs when reading the jar file
     * @throws FileNotFoundException
     *             If the jar file cannot be found
     */
    @PostConstruct
    public void extractFiles() throws IOException {
        try {
        	
        	
			String jarfilepath = new File(JarFileResourcesExtractor.class.getProtectionDomain().getCodeSource().getLocation()
					    .toURI()).getPath();
			System.out.println("extractFiles filepath = " + jarfilepath);
			
        	
            //String path = servletContext.getRealPath("/WEB-INF/lib/" + jarFile);
            
            //logger.info("extractFiles path = " + path);
            JarFile jarFile = new JarFile(jarfilepath);

            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (pathMatcher.match(resourcePathPattern, entry.getName())) {
                    String fileName = entry.getName().replaceFirst(".*\\/", "");
                    logger.info("extractFiles entry.getRealName = " + entry.getRealName());
                    logger.info("extractFiles entry.getName = " + entry.getName());
                    File destinationFolder = new File(servletContext.getRealPath(destination));
                    InputStream inputStream = jarFile.getInputStream(entry);
                    File materializedJsp = new File(destinationFolder, fileName);
                    listOfCopiedFiles.add(materializedJsp);
                    FileOutputStream outputStream = new FileOutputStream(materializedJsp);
                    copyAndClose(inputStream, outputStream);
                }
            }

        }
        catch (MalformedURLException e) {
            throw new FileNotFoundException("Cannot find jar file in libs: " + jarFile);
        }
        catch (IOException e) {
            throw new IOException("IOException while moving resources.", e);
        } catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public static int IO_BUFFER_SIZE = 8192;

    private static void copyAndClose(InputStream in, OutputStream out) throws IOException {
        try {
            byte[] b = new byte[IO_BUFFER_SIZE];
            int read;
            while ((read = in.read(b)) != -1) {
                out.write(b, 0, read);
            }
        } finally {
            in.close();
            out.close();
        }
    }
}