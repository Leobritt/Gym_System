# Gym_System
Java Web Project using Servlet
Technologies Used:
- JSP
- PostgreSql
- Java
- Css 3
- Apache TomCat version 9.0
- Html 5
--------------------------------------------------------------------------------------------------------------------

To use the application on WINDOWS it is necessary to download the following programs:

. Eclipse ide for Enterprise java and web, where you can find the download at the following link:
(https://www.eclipse.org/downloads/packages/release/2023-03/r/eclipse-ide-enterprise-java-and-web-developers)
. Apache Tomcat version 9.0, available at the following link: (https://tomcat.apache.org)

. PostgreSQL, also available at the following link: ( https://www.postgresql.org/download/ )

—------------------------------------------------ ------------------------------------------------------------------------------------

To use the application on LINUX it is necessary to download the following programs:

JDK

The first step to create a Java development platform is the installation of the JDK (Java Development Kit), as we will see in the following step by step: (it can be used in Ubuntu).

Open the terminal and run the command sudo add-apt-repository ppa:webupd8team/java and hit enter.
Update the list of available packages with the sudo apt-get update command.
Enter the command sudo apt-get install oracle-java7-installer for the JDK installation. Then a message will appear asking if you want to continue. Type S and hit enter.
Another message will appear. Hit enter again.
The next message is to accept the Oracle Binary Code license terms. Choose the “Yes” option.
Wait for the download to finish and check the successful JDK installation message.
Run the command java -version and then javac -version to check the installed JDK and compiler version

-------------------------------------------------------------------------------------------------------------------------------

Java EE

To start its installation, it is necessary to download the most recent version from the Eclipse website, selecting the architecture of your system (32 or 64 bit) and clicking on the download option. Then follow step by step:


Open the terminal and unpack the tar.gz file, executing the command tar -xvzf eclipse-jee-mars-R-linux-gtk-x86_64.tar.gz;
Once unzipped, move Eclipse to the /opt directory, with the command sudo mv eclipse /opt;
Run the command sudo nano /usr/share/applications/eclipse.desktop to create the Eclipse Link on your Desktop;
Paste the code block below, with the file open:
[Desktop Entry]
Name=Eclipse Luna
Type=Application
Exec=/opt/eclipse/eclipse
terminal=false
Icon=/opt/eclipse/icon.xpm
Comment=Integrated Development Environment
NoDisplay=false
Categories=Development;IDE;
Name[en]=Eclipse

- Finally, to save the changes made, press Ctrl + O and Enter. To exit, Ctrl + X. Now, it is possible to visualize the icon.

--------------------------------------------------------------------------------------------------------------------------------

Tom Cat

Tomcat is a servelet container and must be installed to create a Java environment on your Linux. See the 4 steps for installation:

Download Tomcat from the server's official website, clicking on the “tar.gz” option, under Binary Distributions, and save it in a directory;
Open the terminal to unpack Tomcat in the chosen directory, with the command tar -zxvf apache-tomcat-8.0.26.tar.gz;
Now, move Tomcat to the /etc folder, with the command sudo mv apache-tomcat-8.0.26 /etc;
Finally, it is necessary to give permission on the folder when running Eclipse. Use the command sudo chmod 775 /etc/apache-tomcat-8.0.26/ in the terminal.

--------------------------------------------------------------------------------------------------------------------------------

Tomcat Settings in Eclipse
After following the steps above, it's time to configure Eclipse to run Tomcat:
Open Eclipse and select the folder where you will save your projects;
Click on the “Workbench” option, located on the right side of the screen;
Open the Server tab and click on the option “No servers are available. Click this link to create a new server to add Tomcat”;
Then just select Tomcat in the Apache folder and click “Next”;
In Browser, select the Tomcat directory and click “Finish”.

--------------------------------------------------------------------------------------------------

PostgreSQL
Remember: before starting the steps below, you need to access your VPS via SSH. Check out this Putty tutorial to learn how to do this.
To start using the application, update the local package index:
sudo apt update
Then, install PostgreSQL and the contrib package, which provides additional features. For this task, use the command below:
sudo apt install postgresql postgresql-contrib
This command installs PostgreSQl. To use it, you will now need to do some basic configuration.


PostgreSQL Check
Now that you've completed installing Postgres on Ubuntu, the services will run automatically.
As a first step, verify the installation by connecting to the PostgreSQL database with psql.
psql is a command line used to interact with the PostgreSQL server. This will show the server version.


sudo -u postgres psql -c "SELECT version();"


To log into PostgreeSQL as a postgre user, you can use psql. This can be done as shown below:


sudo su - postgres


To use Postgre, type in the terminal:


psql


This will grant access to PostgreSQl. If you want to leave the session, just use:


\q
