/*
 * DOSBox, Scrum.org, Professional Scrum Developer Training
 * Authors: Rainer Grau, Daniel Tobler, Zuehlke Technology Group
 * Copyright (c) 2013 All Right Reserved
 */ 

package command.library;

import interfaces.IDrive;
import interfaces.IOutputter;
import command.framework.Command;
import filesystem.File;

class CmdMkFile extends Command {

	public CmdMkFile(String cmdName, IDrive drive) {
		super(cmdName, drive);
	}

	@Override
	public void execute(IOutputter outputter) {
		String fileName = this.getParameterAt(0);
                File newFile;
                String fileContent;
                
                Boolean check=true;
                for (int i = 0; i < this.getDrive().getCurrentDirectory().getNumberOfContainedFiles(); i++) {
                    if(this.getDrive().getCurrentDirectory().getContent().get(i).getName().equals(fileName)){
                        check = false;
                    }
                }
                if(check){
                    if(this.getParameterCount()==2){
                        fileContent = this.getParameterAt(1);
                        newFile = new File(fileName, fileContent);
                    }else{
                        newFile = new File(fileName, "");
                    }

                    this.getDrive().getCurrentDirectory().add(newFile);
                }else{
                    System.err.println("Error: File dengan nama yang sama sudah ada di directory");
                }
	}
}
