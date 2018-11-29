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
class CmdHelp extends Command {
        protected CmdHelp(String name, IDrive drive) {
		super(name, drive);
	}
        
    	@Override
    public void execute(IOutputter outputter) {
        if(this.getParameterCount()==0){
            System.out.println("CD\t: Displays the name of or changes the current directory");
            System.out.println("DIR\t: Displays a list of files and subdirectories in a directory");
            System.out.println("EXIT\t: Quits the CMD.EXE.");
            System.out.println("FORMAT\t: Formats a disk for use with Windows.");
            System.out.println("HELP\t: Provides Help Information for Windows commands.");
            System.out.println("LABEL\t: Creates, changes, or deletes the volume label of a disk.");
            System.out.println("MKDIR\t: Creates a directory");
            System.out.println("MKFILE\t: Creates a file");
            System.out.println("MOVE\t: Moves one or more files from one directorie to another directory.");
        }else{
            String command = this.getParameterAt(0).toLowerCase();
            if(command.equals("cd")){
                System.out.println("CD\t: Displays the name of or changes the current directory.");
            }else if(command.equals("dir")){
                System.out.println("DIR\t: Displays a list of files and subdirectories in a directory.");
            }else if(command.equals("exit")){
                System.out.println("EXIT\t: Quits the CMD.EXE.");
            }else if(command.equals("format")){
                System.out.println("FORMAT\t: Formats a disk for use with Windows.");
            }else if(command.equals("help")){
                System.out.println("HELP\t: Provides Help Information for Windows commands.");
            }else if(command.equals("label")){
                System.out.println("LABEL\t: Creates, changes, or deletes the volume label of a disk.");
            }else if(command.equals("mkdir")){
                System.out.println("MKDIR\t: Creates a directory");
            }else if(command.equals("mkfile")){
                System.out.println("MKFILE\t: Creates a file");
            }else if(command.equals("move")){
                System.out.println("MOVE\t: Moves one or more files from one directorie to another directory.");
            }else{
                System.err.print("Error: This command is not supported by the help utility.");
            }
        }
    }
}
