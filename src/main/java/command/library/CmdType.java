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
class CmdType extends Command {

    protected CmdType(String name, IDrive drive) {
        super(name, drive);
    }

    @Override
    public void execute(IOutputter outputter) {
        if (this.getParameterCount() == 0) {
            
        } else if (this.getParameterCount() == 1) {
            if (this.getParameterAt(0).equals("/w")) {
                
            } else {
                System.err.println("Error: Command '"+this.getParameterAt(0) +"' not found");
            }
        } else {
        }
    }
}
