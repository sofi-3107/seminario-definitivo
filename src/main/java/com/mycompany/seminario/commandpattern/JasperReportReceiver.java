
package com.mycompany.seminario.commandpattern;

import com.mycompany.seminario.database.DBConnectionProvider;
import java.sql.Connection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sofi
 */

/* Esta implementación se realiza con JasperReports, se podría realizar con otra herramienta agregando otra clase
    que implemente la interfaz en el comando concreto y la llame. No tiene mucho sentido crear otro receiver con el 
    mismo  código  y que varíe la ruta del archivo y los parámetros únicamente.
*/
public class JasperReportReceiver {
    
    private Connection con;

    private String reportPath;

    private Map<String, Object> params;

    public JasperReportReceiver(String ruta, Map params) {
        this.params = params;
        this.reportPath = ruta;
        con=DBConnectionProvider.getDatabaseConnection();
    }

    public void imprimirReporte() {
        try {
            JasperDesign jd = JRXmlLoader.load(reportPath);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, params, con);
            JasperViewer v = new JasperViewer(jp, false);
            v.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(JasperReportReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
