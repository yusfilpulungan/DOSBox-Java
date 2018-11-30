/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.library;

import command.framework.Command;
import interfaces.IDrive;
import interfaces.IOutputter;
import java.util.Properties;

/**
 *
 * @author BPS
 */
class CmdVer extends Command {

    protected CmdVer(String name, IDrive drive) {
        super(name, drive);
    }

    @Override
    public void execute(IOutputter outputter) {
        Properties sysProps = System.getProperties();
        String desktop = sysProps.getProperty("sun.desktop");
        String osName = sysProps.getProperty("os.name");
        String verOs = sysProps.getProperty("os.version");

        if (this.getParameterCount() == 0) {
            System.out.println(desktop + ": " + osName + " version:" + verOs);
        } else if (this.getParameterCount() == 1) {
            if (this.getParameterAt(0).equals("/w")) {
                System.out.println(desktop + ": " + osName + " version:" + verOs);
                System.out.println("Abdul Rahman\tabdulrahman@bps.go.id");
                System.out.println("Hasta Nurhusada\thasta.nurhusada@bps.go.id");
                System.out.println("M. Rizki Syazali\tmrizki.syazali@bps.go.id");
                System.out.println("Yusfil Khoir Pulungan\tyusfilpulungan@bps.go.id");
            } else {
                System.err.println("Error: Command '"+this.getParameterAt(0) +"' not found");
            }
        } else {
        }
    }
}
