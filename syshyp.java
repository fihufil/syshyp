/*
 * Copyright © 2015 Filip Dorosz.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 3 as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Author: Filip Dorosz <filip.dorosz@rapidrage.org>
 */

import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class syshyp{

	public static void main(String[] args)
	throws IOException {

	Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Bye Bye!");
            }
        });


	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	Date date = new Date();
	
	RAM ram1 = new RAM();
	CPU cpu1 = new CPU();
	Disk disk1 = new Disk();
	Threat threat1 = new Threat();
	SSHFailed sshfail1 = new SSHFailed();
	SudoFailed sudofail1 = new SudoFailed();

		
	PrintWriter logfileheader = new PrintWriter(new FileWriter("events.log", true));

	logfileheader.println("Starting logging at " + dateFormat.format(date) + " on " + disk1.showSystemVersion());
	logfileheader.println("Processor: " + cpu1.printCPUName() + "| RAM: " + Math.round(ram1.showMaxRAM()) + " GB"); 	

	logfileheader.close();

	while (true) {

		PrintWriter logfile = new PrintWriter(new FileWriter("events.log", true));
		
		/*

		System.out.println("RAM:");
		RAM ram1 = new RAM();
		System.out.println(ram1.fetchRAMUSage());
		System.out.println(ram1.showMaxRAM());

		System.out.println("CPU:");
		CPU cpu1 = new CPU();
		System.out.println(cpu1.fetchCPUUSage());
		System.out.println(cpu1.printCPUName());

		System.out.println("Disk:");
		Disk disk1 = new Disk();
		System.out.println(disk1.fetchDiskUSage());

		System.out.println("Last line from /var/log/auth.log:");
		Threat threat1 = new Threat();
		System.out.println(threat1.searchForString("asdadsaadsdssd"));

		SSHFailed sshfail1 = new SSHFailed();
		System.out.println(sshfail1.fetchSSHFailed());

		SudoFailed sudofail1 = new SudoFailed();
		System.out.println(sudofail1.fetchSudoFailed());

		*/
		date = null;
		date = new Date();

		logfile.print(dateFormat.format(date) + " | RAM: " + Math.round(ram1.fetchRAMUSage()) + "% | CPU: " + Math.round(cpu1.fetchCPUUSage()) + "% | Disk: " + disk1.fetchDiskUSage() + "%" + sshfail1.fetchSSHFailed() + sudofail1.fetchSudoFailed() + "\n");

		logfile.close();

	//Analyzer anal1 = new Analyzer();
	//System.out.println(anal1.fetchLineFromFile("/proc/cpuinfo",4));

	}
	}
}
