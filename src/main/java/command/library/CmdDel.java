/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.library;

import command.framework.Command;
import filesystem.Directory;
import interfaces.IDrive;
import interfaces.IOutputter;

/**
 *
 * @author BPS
 */
class CmdDel extends Command {

    @Override
    public void execute(IOutputter outputter) {
        for (int i = 0; i < getParameterCount(); i++) {

            DeleteDirectory(getParameterAt(i), this.getDrive());
        }

    }

    public CmdDel(String name, IDrive drive) {
        super(name, drive);
    }

    private static void DeleteDirectory(String name, IDrive drive) {
        Boolean check = true;
        for (int i = 0; i < drive.getCurrentDirectory().getContent().size(); i++) {
            if (drive.getCurrentDirectory().getContent().get(i).isDirectory()) {
                if (drive.getCurrentDirectory().getContent().get(i).getName().equals(name)) {
                    check = false;
                    for (int j = 0; j < drive.getCurrentDirectory().getContent().size(); j++) {
                        if (drive.getCurrentDirectory().getContent().get(i).getParent().getName().equals(name)) {
                            drive.getCurrentDirectory().delete(j);
                        }
                    }
                    drive.getCurrentDirectory().delete(i);
                }

            } else {
                if (drive.getCurrentDirectory().getContent().get(i).getName().equals(name)) {
                    check = false;
                    drive.getCurrentDirectory().delete(i);
                }
            }

            if (check) {
                System.err.println("Could not find " + name);
            }
        }

    }

}
