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
import filesystem.FileSystemItem;

class CmdMkFile extends Command {

    public CmdMkFile(String cmdName, IDrive drive) {
        super(cmdName, drive);
    }

    @Override
    public void execute(IOutputter outputter) {
        String fileName = this.getParameterAt(0);
        checkFileName(fileName, outputter);
    }

    private void checkFileName(String fileName, IOutputter outputter) {
        File newFile;
        if (checkItem(fileName)) {
            add(fileName);
        } else {
            outputter.print("Error: File dengan nama yang sama sudah ada di directory");
        }
    }

    private void add(String fileName) {
        File newFile;
        if (this.getParameterCount() == 2) {
            String fileContent = this.getParameterAt(1);
            newFile = new File(fileName, fileContent);
        } else {
            newFile = new File(fileName, "");
        }
        this.getDrive().getCurrentDirectory().add(newFile);
    }

    private Boolean checkItem(String fileName) {
        Boolean check = true;
        FileSystemItem fsi = this.getDrive().getItemFromPath(fileName);
        if (fsi != null) {
            if (!fsi.isDirectory()) {
                check = false;
            }
        }
        return check;
    }
}
