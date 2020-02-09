/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.main;

import core.controller.MainController;
import core.info.Information;
import core.object.User;
import core.utilities.DateManager;
import core.utilities.NumberManager;
import gui.about.About;
import gui.main.reports.Reports;
import gui.pawining.AddNewPawn;
import gui.pawining.SearchPawns;
import gui.pawining.ViewAllPawnRecords;
import gui.tools.ConfigWriter;
import gui.tools.ManageUsers;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Sri Saravana
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Local Variables
     */
    MainController mc;
    java.util.Date utilToday;
    java.sql.Date sqlToday;

    User currentUser;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();

    }

    public MainWindow(MainController controller, User currentUser) {
        this();

        // initiate main controller
        mc = controller;

        // init current user
        this.currentUser = currentUser;

        // set the title and location relative to screen
        this.setTitle(Information.APP_TITLE);
        this.setLocationRelativeTo(null);

        // set today's date
        utilToday = DateManager.getUtilToday();
        sqlToday = DateManager.getSqlToday();

        // generate reportcards
        generateReportCard();

        //user management options switch
        userManagement();

        // override close button
        closeOperation();

    }

    public void display() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void userManagement() {
        if (currentUser.getRole() != User.Role.Administrator) {
            mnuManageUsers.setEnabled(false);
        }
    }


    /*
     ===================================================================================================================
     Operational functions below
     */
    // open add new pawn window
    private void openAddNewPawn() {
        AddNewPawn addNewPawn = new AddNewPawn(mc);
        addNewPawn.display();
    }

    private void openViewPawningRecords() {
        ViewAllPawnRecords pawnRecords = new ViewAllPawnRecords(mc, currentUser);
        pawnRecords.display();
    }

    private void openSearchPawns() {
        SearchPawns searchPawns = new SearchPawns(mc, currentUser);
        searchPawns.display();
    }

    private void generateReportCard() {
        txtTotalPawningAmount.setText(String.format("%1$,.2f", mc.pawnController.getTotalPawningAmount()) + " Rupees");
        txtTotalPawningWeight.setText(String.format("%1$,.2f", mc.pawnController.getTotalPawningWeight()) + " Grams");

        txtTodayPawningAmount.setText(String.format("%1$,.2f", mc.pawnController.getTodayPawningAmount(sqlToday)) + " Rupees");
        txtTodayPawningWeight.setText(String.format("%1$,.2f", mc.pawnController.getTodayPawningWeignt(sqlToday)) + " Grams");

//        System.out.println("firstday: " + DateManager.getFirstDayOfCurrentMonth());
//        System.out.println("today: " + DateManager.getSqlToday());
        
        double monthPawningAmount = mc.pawnController.getPawningAmountBetweenDates(DateManager.getFirstDayOfCurrentMonth(), sqlToday);
        double monthPawningWeight = mc.pawnController.getPawningWeightBetweenDates(DateManager.getFirstDayOfCurrentMonth(), sqlToday);
        
        txtMonthPawningAmount.setText(monthPawningAmount + " Rupees");
        txtMonthPawningWeight.setText(monthPawningWeight + " Grams");

    }

    /*
     END of Operational functions below
     ====================================================================================================================
     */
    private void closeOperation() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
    }

    private void exit() {
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the application?", "Exit Application", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            //closing the database
            mc.getDb().closeDatabase();
            //exit the application
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAddNewPawn = new javax.swing.JButton();
        btnViewPawningRecords = new javax.swing.JButton();
        btnSearchPawns = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTotalPawningAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotalPawningWeight = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTodayPawningAmount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTodayPawningWeight = new javax.swing.JTextField();
        txtMonthPawningAmount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMonthPawningWeight = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        btnRefreshSummeryCard = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuExit = new javax.swing.JMenuItem();
        mnuTools = new javax.swing.JMenu();
        mnuConfig = new javax.swing.JMenuItem();
        mnuManageUsers = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuAboutJewelleryManager = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("The Title Comes Here");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAddNewPawn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddNewPawn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/add.png"))); // NOI18N
        btnAddNewPawn.setText("Add A New Pawn");
        btnAddNewPawn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAddNewPawn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewPawnActionPerformed(evt);
            }
        });

        btnViewPawningRecords.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnViewPawningRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/database.png"))); // NOI18N
        btnViewPawningRecords.setText("View Pawning Records");
        btnViewPawningRecords.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnViewPawningRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPawningRecordsActionPerformed(evt);
            }
        });

        btnSearchPawns.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchPawns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/search.png"))); // NOI18N
        btnSearchPawns.setText("Search Records");
        btnSearchPawns.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSearchPawns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPawnsActionPerformed(evt);
            }
        });

        btnReports.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/receipt.png"))); // NOI18N
        btnReports.setText("Reports");
        btnReports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddNewPawn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewPawningRecords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearchPawns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddNewPawn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewPawningRecords)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchPawns)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReports)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Main street, Kokkatticholai");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Abira Jewellery");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Summery Card"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Total Pawning Amount");

        txtTotalPawningAmount.setEditable(false);
        txtTotalPawningAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalPawningAmount.setForeground(java.awt.Color.blue);
        txtTotalPawningAmount.setPreferredSize(new java.awt.Dimension(50, 23));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total Gold Pawned");

        txtTotalPawningWeight.setEditable(false);
        txtTotalPawningWeight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalPawningWeight.setForeground(java.awt.Color.blue);
        txtTotalPawningWeight.setPreferredSize(new java.awt.Dimension(50, 23));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Today's Pawning Amount");

        txtTodayPawningAmount.setEditable(false);
        txtTodayPawningAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTodayPawningAmount.setForeground(java.awt.Color.blue);
        txtTodayPawningAmount.setPreferredSize(new java.awt.Dimension(50, 23));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gold Pawned Today");

        txtTodayPawningWeight.setEditable(false);
        txtTodayPawningWeight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTodayPawningWeight.setForeground(java.awt.Color.blue);
        txtTodayPawningWeight.setPreferredSize(new java.awt.Dimension(50, 23));

        txtMonthPawningAmount.setEditable(false);
        txtMonthPawningAmount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMonthPawningAmount.setForeground(java.awt.Color.blue);
        txtMonthPawningAmount.setPreferredSize(new java.awt.Dimension(50, 23));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("This Month's Pawning Amount");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Gold Pawned This Month");

        txtMonthPawningWeight.setEditable(false);
        txtMonthPawningWeight.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMonthPawningWeight.setForeground(java.awt.Color.blue);
        txtMonthPawningWeight.setPreferredSize(new java.awt.Dimension(50, 23));

        btnRefreshSummeryCard.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRefreshSummeryCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icons/refresh.png"))); // NOI18N
        btnRefreshSummeryCard.setText("Refresh Summery Card");
        btnRefreshSummeryCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshSummeryCardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotalPawningWeight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTodayPawningAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTodayPawningWeight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMonthPawningAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMonthPawningWeight, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotalPawningAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefreshSummeryCard)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotalPawningAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotalPawningWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTodayPawningAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTodayPawningWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMonthPawningAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMonthPawningWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefreshSummeryCard)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/images/gravitide-logo.png"))); // NOI18N

        mnuFile.setText("File");

        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);

        jMenuBar1.add(mnuFile);

        mnuTools.setText("Tools");

        mnuConfig.setText("Configuration");
        mnuConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConfigActionPerformed(evt);
            }
        });
        mnuTools.add(mnuConfig);

        mnuManageUsers.setText("Manage Users");
        mnuManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuManageUsersActionPerformed(evt);
            }
        });
        mnuTools.add(mnuManageUsers);

        jMenuBar1.add(mnuTools);

        mnuHelp.setText("Help");

        mnuAboutJewelleryManager.setText("About Jewellery Manager");
        mnuAboutJewelleryManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAboutJewelleryManagerActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuAboutJewelleryManager);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewPawnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewPawnActionPerformed
        // TODO add your handling code here:
        openAddNewPawn();
    }//GEN-LAST:event_btnAddNewPawnActionPerformed

    private void btnViewPawningRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPawningRecordsActionPerformed
        // TODO add your handling code here:
        openViewPawningRecords();
    }//GEN-LAST:event_btnViewPawningRecordsActionPerformed

    private void btnSearchPawnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPawnsActionPerformed
        // TODO add your handling code here:
        openSearchPawns();
    }//GEN-LAST:event_btnSearchPawnsActionPerformed

    private void btnRefreshSummeryCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshSummeryCardActionPerformed
        // TODO add your handling code here:
        generateReportCard();
    }//GEN-LAST:event_btnRefreshSummeryCardActionPerformed

    private void mnuAboutJewelleryManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAboutJewelleryManagerActionPerformed
        // TODO add your handling code here:
        About about = new About(this, true);
        about.display();
    }//GEN-LAST:event_mnuAboutJewelleryManagerActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        // TODO add your handling code here:
        exit();
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConfigActionPerformed
        // TODO add your handling code here:
        ConfigWriter configWriter = new ConfigWriter();
        configWriter.display();

    }//GEN-LAST:event_mnuConfigActionPerformed

    private void mnuManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuManageUsersActionPerformed
        // TODO add your handling code here:
        ManageUsers manageUsers = new ManageUsers(mc);
        manageUsers.display();
    }//GEN-LAST:event_mnuManageUsersActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        // TODO add your handling code here:
        Reports reports = new Reports(mc, currentUser);
        reports.display();
    }//GEN-LAST:event_btnReportsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewPawn;
    private javax.swing.JButton btnRefreshSummeryCard;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnSearchPawns;
    private javax.swing.JButton btnViewPawningRecords;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem mnuAboutJewelleryManager;
    private javax.swing.JMenuItem mnuConfig;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuManageUsers;
    private javax.swing.JMenu mnuTools;
    private javax.swing.JTextField txtMonthPawningAmount;
    private javax.swing.JTextField txtMonthPawningWeight;
    private javax.swing.JTextField txtTodayPawningAmount;
    private javax.swing.JTextField txtTodayPawningWeight;
    private javax.swing.JTextField txtTotalPawningAmount;
    private javax.swing.JTextField txtTotalPawningWeight;
    // End of variables declaration//GEN-END:variables
}