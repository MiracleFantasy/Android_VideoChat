
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sumantra
 */
public class SetPassword extends javax.swing.JFrame implements Runnable{

    private File file1, file2;
    private final LookAndFeelInfo[] looks;
    private JTextArea log;
    private Thread thd;
    /**
     * Creates new form SetPassword
     */
    public SetPassword(File file1,File file2) {
        initComponents();
        thd=new Thread(this);
		thd.start();
        try
               {
               String dir = System.getProperty("user.dir");
               Image img= ImageIO.read(new File(dir+"\\"+"server.jpg"));
               setIconImage(img);
               }
        catch(Exception e)
        {
            System.out.println("Error image: " + e.getMessage());
        }
                //change the required look and feel and get rest all default the look and feels
                UIManager.put("nimbusBase", new Color(115,164,209));
                UIManager.put("nimbusBlueGrey", new Color(200,200,200));
                UIManager.put("control", new Color(115,164,209));
		looks = UIManager.getInstalledLookAndFeels();
		//set Nimbus as the look and feel
		 try 
		 {
			 for(int i=0;i<looks.length;i++)
			 {
				 if(looks[i].getName().equalsIgnoreCase("Nimbus"))
				 {
					 UIManager.setLookAndFeel(
							 looks[ i ].getClassName() );
					 SwingUtilities.updateComponentTreeUI( this );
					 break;
				 }
			 }
		 }	
		 catch ( Exception exception ) 
		 {
			 exception.printStackTrace();
		 }
                 setDefaultCloseOperation(EXIT_ON_CLOSE);
                 if(jPasswordField1.getText().equals(null)||jPasswordField2.getText().equals(null)){
                    jButton1.setEnabled(false);
                }
        else
            jButton1.setEnabled(true);
		setSize(250,250);
		setLocation(500,225);
                setResizable(false);
                setVisible(true);
                this.file1 = file1;
                this.file2 = file2;
                this.log = log;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Set Admin Password");

        jLabel2.setText("Password");

        jLabel3.setText("Confirm Password");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                .addComponent(jPasswordField2))
                            .addGap(20, 20, 20)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        serversetter(file2);
        passwordsetter(file1);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    // End of variables declaration//GEN-END:variables

    private void passwordsetter(File file) {
        try{
            if(jPasswordField1.getText().equals(jPasswordField2.getText()))
            {                
                             file.createNewFile();
                             FileWriter fw = new FileWriter(file.getAbsoluteFile());
                             //Write labels and corresponding fields to text file
                             BufferedWriter outfile = new BufferedWriter(fw);
                             outfile.write(jPasswordField1.getText());
                             outfile.close();
                             this.setVisible(false);
                             thd.stop();
                             new Layout();
            }
            else{
                JOptionPane.showMessageDialog(null,"Password Mismatch!! TRY AGAIN");
                jPasswordField1.setText("");
                jPasswordField2.setText("");
            }}
            catch(IOException io)
    {
        JOptionPane.showMessageDialog(null,"Something went wrong!! TRY AGAIN");
    }
    }

    private void serversetter(File file) {
        try{
            file.createNewFile();
                             FileWriter fw = new FileWriter(file.getAbsoluteFile());
                             //Write labels and corresponding fields to text file
                             BufferedWriter outfile = new BufferedWriter(fw);
                             
                             outfile.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><server>\n" +
"	<database>\n" +
"		<host>localhost</host>\n" +
"		<dname>userdetails</dname>\n" +
"		<username>root</username>\n" +
"		<password>tutul</password>\n" +
"	</database>\n" +
"        \n" +
"</server>");
          
                             outfile.close();
        }catch(IOException io)
        {
            JOptionPane.showMessageDialog(null,"Something went wrong!! TRY AGAIN");
        }
        }


    @Override
    public void run() {
       while(true)
       {try {
            thd.sleep(1000);
        } catch (InterruptedException ex) {
           JOptionPane.showMessageDialog(null,"Something went wrong!! TRY AGAIN");
        }
        System.out.println(jPasswordField1.getText());
        if(jPasswordField1.getText().equals("")||jPasswordField2.getText().equals(""))
        {
            jButton1.setEnabled(false);
        }
        else
            jButton1.setEnabled(true);
    }}
    }
