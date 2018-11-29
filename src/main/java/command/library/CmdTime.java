/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.library;

import command.framework.Command;
import interfaces.IDrive;
import interfaces.IOutputter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author BPS
 */
class CmdTime extends Command {
        protected CmdTime(String name, IDrive drive) {
		super(name, drive);
	}
        
    	@Override
    public void execute(IOutputter outputter) {
        if(this.getParameterCount()==0){
            Date date;
            date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            System.out.println(dateFormat.format(date));
        }else if(this.getParameterCount()==1){
            if(this.getParameterAt(0).equals("gaga")){
                System.err.println("Error: Command not found");
            }
        }else{
            
        }
    }
}
