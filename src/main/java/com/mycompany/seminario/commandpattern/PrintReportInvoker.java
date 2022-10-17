
package com.mycompany.seminario.commandpattern;

/**
 *
 * @author Sofi
 */
public class PrintReportInvoker {
    
    PrintReportInterface reporter;
    
    public void setReporter(PrintReportInterface reporter){
        this.reporter=reporter;
    }
    
    public void print(){
        reporter.executePrint();
    }
    
}
