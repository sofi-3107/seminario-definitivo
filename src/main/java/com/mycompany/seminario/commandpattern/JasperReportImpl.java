package com.mycompany.seminario.commandpattern;

import java.util.Map;

/**
 *
 * @author Sofi
 */
public class JasperReportImpl implements PrintReportInterface {

    JasperReportReceiver receiver;

    public JasperReportImpl(String ruta, Map params) {
        receiver = new JasperReportReceiver(ruta, params);
    }

    @Override
    public void executePrint() {
        receiver.imprimirReporte();
    }

}
