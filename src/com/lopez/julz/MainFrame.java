/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lopez.julz;

import db.DatabaseConnection;
import db.ORAssigningDao;
import db.PaidBillsDao;
import helpers.Auth;
import helpers.ConfigFileHelpers;
import helpers.Notifiers;
import helpers.ObjectHelpers;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.RoundingMode;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;
import pojos.ORAssigning;
import pojos.PaidBills;
import pojos.Server;

/**
 *
 * @author Julio Lopez
 */
public class MainFrame extends javax.swing.JFrame {
    public PowerBillsPanel powerBillsPanel;
    public BAPAPaymentsPanel bAPAPaymentsPanel;
    public ServiceConnectionsPanel serviceConnectionsPanel;
    public DCRPanel dcrPanel;
    public OCLPanel oclPanel;
    public ORMaintenancePanel ormanMaintenance;
    public MiscellaneousPanel miscellaneousPanel;
    public ORCancellationPanel cancellationPanel;
    public PrepaymentPanel prepaymentPanel;
    public GroupPaymentsPanel groupPaymentsPanel;
    
    public Server server;
    public String office;
    public DatabaseConnection db;
    public Connection connection;
    
    public pojos.Login login;
    
    public ORAssigning currentOr;
    
    JButton dummyBtn;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("NONECO Tellering");
        
        logoutBtn.setFocusable(false);
        
        // GET LOGGED USER
        login = Auth.getActiveUser();
        
        server = ConfigFileHelpers.getServer();
        office = ConfigFileHelpers.getOffice();
        
        db = new DatabaseConnection();
        connection = db.getDbConnectionFromDatabase(server);
        
        // set login displays
        usernamelabel.setText(login != null ? login.getUsername() : "Account Not Found");
        userIdLabel.setText("User ID: " + login != null ? login.getId(): "Account Not Found");
        
        // TEST IF OR EXISTS ON THIS USER
        currentOr = ORAssigningDao.getCurrentOR(connection, login.getId());
        if (currentOr != null) {
            powerBillsPanel = new PowerBillsPanel(login, null);
            bAPAPaymentsPanel = new BAPAPaymentsPanel(login, null);
            serviceConnectionsPanel = new ServiceConnectionsPanel(login, null);
            dcrPanel = new DCRPanel(login);
            oclPanel = new OCLPanel(login, null);
            ormanMaintenance = new ORMaintenancePanel(login);
            miscellaneousPanel = new MiscellaneousPanel(login, null);
            cancellationPanel = new ORCancellationPanel(login);
            prepaymentPanel = new PrepaymentPanel(login, null);
            groupPaymentsPanel = new GroupPaymentsPanel(login, null);

    //        mainSplitPane.setRightComponent(dcrPanel); // pwerbillpanel
            mainSplitPane.setRightComponent(powerBillsPanel);

            billsPayment.setForeground(Color.decode("#00968b"));
            billsPayment.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
            dummyBtn = billsPayment;
        } else {
            String startOr = JOptionPane.showInputDialog(null, "Because you haven't recorded any payment yet, you are required to input your initial OR Number.", "OR Number Initialization", JOptionPane.WARNING_MESSAGE);
            if (startOr != null) {
                powerBillsPanel = new PowerBillsPanel(login, startOr);
                bAPAPaymentsPanel = new BAPAPaymentsPanel(login, startOr);
                serviceConnectionsPanel = new ServiceConnectionsPanel(login, startOr);
                dcrPanel = new DCRPanel(login);
                oclPanel = new OCLPanel(login, startOr);
                ormanMaintenance = new ORMaintenancePanel(login);
                miscellaneousPanel = new MiscellaneousPanel(login, startOr);
                cancellationPanel = new ORCancellationPanel(login);
                prepaymentPanel = new PrepaymentPanel(login, startOr);
                groupPaymentsPanel = new GroupPaymentsPanel(login, startOr);
                
                //        mainSplitPane.setRightComponent(dcrPanel); // pwerbillpanel
                mainSplitPane.setRightComponent(powerBillsPanel);

                billsPayment.setForeground(Color.decode("#00968b"));
                billsPayment.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
                dummyBtn = billsPayment;
            } else {
                Notifiers.showErrorMessage("OR Not Initialized", "Invalid input! OR number needs to be initialized.");
                dispose();
            }
        }
        
        serverLabel.setText("SERVER: " + ConfigFileHelpers.getServerName());
        
        showClock();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainSplitPane = new javax.swing.JSplitPane();
        menuPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        billsPayment = new javax.swing.JButton();
        bapaPayments = new javax.swing.JButton();
        groupPayments = new javax.swing.JButton();
        serviceConnectionPayments = new javax.swing.JButton();
        oclPaymentsMenu = new javax.swing.JButton();
        miscellaneousPaymentsMenu = new javax.swing.JButton();
        prepaymentDeposits = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        sumORBtn = new javax.swing.JButton();
        orCancellation = new javax.swing.JButton();
        orMaintenance = new javax.swing.JButton();
        dcr = new javax.swing.JButton();
        timeLabel = new javax.swing.JLabel();
        serverLabel = new javax.swing.JLabel();
        userIdLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        reprintOR = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainSplitPane.setDividerLocation(200);
        mainSplitPane.setDividerSize(3);

        menuPanel.setMaximumSize(new java.awt.Dimension(130, 32767));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setText("Main Menu");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/account_circle_FILL1_wght400_GRAD0_opsz48.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        usernamelabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        usernamelabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernamelabel.setText("username");

        logoutBtn.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.setFocusable(false);
        logoutBtn.setRequestFocusEnabled(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernamelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernamelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        billsPayment.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        billsPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/request_quote_FILL1_wght400_GRAD0_opsz24.png"))); // NOI18N
        billsPayment.setText("Bills Payment");
        billsPayment.setToolTipText("");
        billsPayment.setFocusable(false);
        billsPayment.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        billsPayment.setMargin(new java.awt.Insets(5, 5, 5, 5));
        billsPayment.setMaximumSize(new java.awt.Dimension(175, 39));
        billsPayment.setMinimumSize(new java.awt.Dimension(175, 39));
        billsPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billsPaymentActionPerformed(evt);
            }
        });
        jToolBar1.add(billsPayment);

        bapaPayments.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        bapaPayments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mediation_FILL1_wght400_GRAD0_opsz24.png"))); // NOI18N
        bapaPayments.setText("BAPA Payments");
        bapaPayments.setToolTipText("");
        bapaPayments.setFocusable(false);
        bapaPayments.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        bapaPayments.setMargin(new java.awt.Insets(5, 5, 5, 5));
        bapaPayments.setMaximumSize(new java.awt.Dimension(175, 39));
        bapaPayments.setMinimumSize(new java.awt.Dimension(175, 39));
        bapaPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bapaPaymentsActionPerformed(evt);
            }
        });
        jToolBar1.add(bapaPayments);

        groupPayments.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        groupPayments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/diversity_3_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        groupPayments.setText("Group Payments");
        groupPayments.setToolTipText("");
        groupPayments.setFocusable(false);
        groupPayments.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        groupPayments.setMargin(new java.awt.Insets(5, 5, 5, 5));
        groupPayments.setMaximumSize(new java.awt.Dimension(175, 39));
        groupPayments.setMinimumSize(new java.awt.Dimension(175, 39));
        groupPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupPaymentsActionPerformed(evt);
            }
        });
        jToolBar1.add(groupPayments);

        serviceConnectionPayments.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        serviceConnectionPayments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/power_FILL1_wght400_GRAD0_opsz24.png"))); // NOI18N
        serviceConnectionPayments.setText("Service Connections");
        serviceConnectionPayments.setToolTipText("");
        serviceConnectionPayments.setFocusable(false);
        serviceConnectionPayments.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        serviceConnectionPayments.setMargin(new java.awt.Insets(5, 5, 5, 5));
        serviceConnectionPayments.setMaximumSize(new java.awt.Dimension(175, 39));
        serviceConnectionPayments.setMinimumSize(new java.awt.Dimension(175, 39));
        serviceConnectionPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceConnectionPaymentsActionPerformed(evt);
            }
        });
        jToolBar1.add(serviceConnectionPayments);

        oclPaymentsMenu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        oclPaymentsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/receipt_long_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        oclPaymentsMenu.setText("OCL Payments");
        oclPaymentsMenu.setToolTipText("");
        oclPaymentsMenu.setFocusable(false);
        oclPaymentsMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        oclPaymentsMenu.setMargin(new java.awt.Insets(5, 5, 5, 5));
        oclPaymentsMenu.setMaximumSize(new java.awt.Dimension(175, 35));
        oclPaymentsMenu.setMinimumSize(new java.awt.Dimension(175, 35));
        oclPaymentsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oclPaymentsMenuActionPerformed(evt);
            }
        });
        jToolBar1.add(oclPaymentsMenu);

        miscellaneousPaymentsMenu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        miscellaneousPaymentsMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/shopping_cart_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        miscellaneousPaymentsMenu.setText("Miscellaneous");
        miscellaneousPaymentsMenu.setToolTipText("");
        miscellaneousPaymentsMenu.setFocusable(false);
        miscellaneousPaymentsMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        miscellaneousPaymentsMenu.setMargin(new java.awt.Insets(5, 5, 5, 5));
        miscellaneousPaymentsMenu.setMaximumSize(new java.awt.Dimension(175, 35));
        miscellaneousPaymentsMenu.setMinimumSize(new java.awt.Dimension(175, 35));
        miscellaneousPaymentsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miscellaneousPaymentsMenuActionPerformed(evt);
            }
        });
        jToolBar1.add(miscellaneousPaymentsMenu);

        prepaymentDeposits.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        prepaymentDeposits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/account_balance_wallet_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        prepaymentDeposits.setText("Prepayments/Deposits");
        prepaymentDeposits.setToolTipText("");
        prepaymentDeposits.setFocusable(false);
        prepaymentDeposits.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        prepaymentDeposits.setMargin(new java.awt.Insets(5, 5, 5, 5));
        prepaymentDeposits.setMaximumSize(new java.awt.Dimension(175, 35));
        prepaymentDeposits.setMinimumSize(new java.awt.Dimension(175, 35));
        prepaymentDeposits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prepaymentDepositsActionPerformed(evt);
            }
        });
        jToolBar1.add(prepaymentDeposits);
        jToolBar1.add(jSeparator2);

        sumORBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        sumORBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/note_add_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        sumORBtn.setText("Sum OR");
        sumORBtn.setToolTipText("");
        sumORBtn.setFocusable(false);
        sumORBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        sumORBtn.setMargin(new java.awt.Insets(5, 5, 5, 5));
        sumORBtn.setMaximumSize(new java.awt.Dimension(175, 35));
        sumORBtn.setMinimumSize(new java.awt.Dimension(175, 35));
        sumORBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sumORBtnActionPerformed(evt);
            }
        });
        jToolBar1.add(sumORBtn);

        orCancellation.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        orCancellation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        orCancellation.setText("ORCancellation");
        orCancellation.setToolTipText("");
        orCancellation.setFocusable(false);
        orCancellation.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        orCancellation.setMargin(new java.awt.Insets(5, 5, 5, 5));
        orCancellation.setMaximumSize(new java.awt.Dimension(175, 35));
        orCancellation.setMinimumSize(new java.awt.Dimension(175, 35));
        orCancellation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orCancellationActionPerformed(evt);
            }
        });
        jToolBar1.add(orCancellation);

        orMaintenance.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        orMaintenance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/build_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        orMaintenance.setText("OR Maintenance");
        orMaintenance.setToolTipText("");
        orMaintenance.setFocusable(false);
        orMaintenance.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        orMaintenance.setMargin(new java.awt.Insets(5, 5, 5, 5));
        orMaintenance.setMaximumSize(new java.awt.Dimension(175, 35));
        orMaintenance.setMinimumSize(new java.awt.Dimension(175, 35));
        orMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orMaintenanceActionPerformed(evt);
            }
        });
        jToolBar1.add(orMaintenance);

        dcr.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        dcr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/description_FILL1_wght400_GRAD0_opsz20.png"))); // NOI18N
        dcr.setText("DCR");
        dcr.setToolTipText("");
        dcr.setFocusable(false);
        dcr.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        dcr.setMargin(new java.awt.Insets(5, 5, 5, 5));
        dcr.setMaximumSize(new java.awt.Dimension(175, 35));
        dcr.setMinimumSize(new java.awt.Dimension(175, 35));
        dcr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcrActionPerformed(evt);
            }
        });
        jToolBar1.add(dcr);

        timeLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        serverLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(userIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serverLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLabel)
                .addContainerGap())
        );

        mainSplitPane.setLeftComponent(menuPanel);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainSplitPane)
        );

        jMenu1.setText("Tools");

        reprintOR.setText("Re-Print OR");
        jMenu1.add(reprintOR);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void billsPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billsPaymentActionPerformed
        mainSplitPane.setRightComponent(powerBillsPanel);
        powerBillsPanel.updateOR();
        
        dummyBtn.setForeground(Color.black);
        dummyBtn.setBorder(logoutBtn.getBorder());
        billsPayment.setForeground(Color.decode("#00968b"));
        billsPayment.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
        dummyBtn = billsPayment;
    }//GEN-LAST:event_billsPaymentActionPerformed

    private void bapaPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bapaPaymentsActionPerformed
        mainSplitPane.setRightComponent(bAPAPaymentsPanel);
        bAPAPaymentsPanel.updateOR();
        
        dummyBtn.setForeground(Color.black);
        dummyBtn.setBorder(logoutBtn.getBorder());
        bapaPayments.setForeground(Color.decode("#00968b"));
        bapaPayments.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
        dummyBtn = bapaPayments;
    }//GEN-LAST:event_bapaPaymentsActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void sumORBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sumORBtnActionPerformed
        JDialog sumOrDialog = new JDialog(this);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) size.getWidth();
        int y = (int) size.getHeight();
        sumOrDialog.setTitle("Sum OR");

        JPanel mainPanel = new JPanel(new GridLayout(0, 6, 5, 5));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel fromLabel = new JLabel("From");
        fromLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(fromLabel);
        JTextField fromOr = new JTextField();
        fromOr.setPreferredSize(new Dimension(120, 36));
        fromOr.setFont(new Font("Arial", Font.BOLD, 16));         
        mainPanel.add(fromOr);
        
        JLabel noOfPayments = new JLabel("No. of Payments");
        noOfPayments.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(noOfPayments);
        JTextField noOfPaymentsField = new JTextField();
        noOfPaymentsField.setPreferredSize(new Dimension(120, 36));
        noOfPaymentsField.setHorizontalAlignment(JTextField.RIGHT);
        noOfPaymentsField.setFont(new Font("Arial", Font.BOLD, 16));  
        noOfPaymentsField.setEnabled(false);
        mainPanel.add(noOfPaymentsField);
        
        JLabel amntPaid = new JLabel("Enter Amnt. Paid");
        amntPaid.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(amntPaid);
        NumberFormat format = NumberFormat.getInstance();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        format.setRoundingMode(RoundingMode.HALF_UP);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Double.class);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        JFormattedTextField amountPaidField = new JFormattedTextField(formatter);
        amountPaidField.setPreferredSize(new Dimension(120, 36));
        amountPaidField.setHorizontalAlignment(JTextField.RIGHT);
        amountPaidField.setFont(new Font("Arial", Font.BOLD, 16)); 
        mainPanel.add(amountPaidField);
        
        JLabel toLabel = new JLabel("To");
        toLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(toLabel);
        JTextField toOr = new JTextField();
        toOr.setPreferredSize(new Dimension(120, 36));
        toOr.setFont(new Font("Arial", Font.BOLD, 16));  
        mainPanel.add(toOr);
        
        JLabel totalAmount = new JLabel("Total Amount");
        totalAmount.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(totalAmount);
        JFormattedTextField totalAmountField = new JFormattedTextField(formatter);
        totalAmountField.setPreferredSize(new Dimension(120, 36));
        totalAmountField.setHorizontalAlignment(JTextField.RIGHT);
        totalAmountField.setFont(new Font("Arial", Font.BOLD, 16));  
        totalAmountField.setFocusable(false);
        mainPanel.add(totalAmountField);
        
        JLabel change = new JLabel("Change");
        change.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(change);
        JFormattedTextField changeField = new JFormattedTextField(formatter);
        changeField.setPreferredSize(new Dimension(120, 36));
        changeField.setHorizontalAlignment(JTextField.RIGHT);
        changeField.setForeground(Color.red);
        changeField.setFont(new Font("Arial", Font.BOLD, 16));
        changeField.setEnabled(false);
        mainPanel.add(changeField);
        
        fromOr.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    toOr.setText(fromOr.getText().substring(0, 4));
                    toOr.requestFocus();
                }
            }
        });
        
        toOr.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    List<PaidBills> ors = PaidBillsDao.getSumOr(connection, fromOr.getText(), toOr.getText());
                    noOfPaymentsField.setText(ors.size() + "");
                    totalAmountField.setValue(getSumOr(ors));
                    amountPaidField.requestFocus();
                }
            }
        });
        
        amountPaidField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sumOrDialog.dispose();
                } else {
                    if (totalAmountField.getValue() != null) {
                        double change = Double.valueOf(amountPaidField.getText()) - Double.valueOf(totalAmountField.getValue().toString());
                        changeField.setValue(change);
                    }                    
                }
            }
        });
        
        sumOrDialog.add(mainPanel);        
        sumOrDialog.setLocation(x/4, y/4);
        sumOrDialog.pack();
        sumOrDialog.setVisible(true);
    }//GEN-LAST:event_sumORBtnActionPerformed

    private void serviceConnectionPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceConnectionPaymentsActionPerformed
        mainSplitPane.setRightComponent(serviceConnectionsPanel);
        serviceConnectionsPanel.updateOR();
        
        dummyBtn.setForeground(Color.black);
        dummyBtn.setBorder(logoutBtn.getBorder());
        serviceConnectionPayments.setForeground(Color.decode("#00968b"));
        serviceConnectionPayments.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
        dummyBtn = serviceConnectionPayments;
    }//GEN-LAST:event_serviceConnectionPaymentsActionPerformed

    private void oclPaymentsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oclPaymentsMenuActionPerformed
        mainSplitPane.setRightComponent(oclPanel);
        oclPanel.fetchOR();
        
        dummyBtn.setForeground(Color.black);
        dummyBtn.setBorder(logoutBtn.getBorder());
        oclPaymentsMenu.setForeground(Color.decode("#00968b"));
        oclPaymentsMenu.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
        dummyBtn = oclPaymentsMenu;
    }//GEN-LAST:event_oclPaymentsMenuActionPerformed

    private void miscellaneousPaymentsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miscellaneousPaymentsMenuActionPerformed
        mainSplitPane.setRightComponent(miscellaneousPanel);
        miscellaneousPanel.fetchOR();
        
        dummyBtn.setForeground(Color.black);
        dummyBtn.setBorder(logoutBtn.getBorder());
        miscellaneousPaymentsMenu.setForeground(Color.decode("#00968b"));
        miscellaneousPaymentsMenu.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
        dummyBtn = miscellaneousPaymentsMenu;
    }//GEN-LAST:event_miscellaneousPaymentsMenuActionPerformed

    private void orCancellationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orCancellationActionPerformed
        mainSplitPane.setRightComponent(cancellationPanel);
        
        dummyBtn.setForeground(Color.black);
        dummyBtn.setBorder(logoutBtn.getBorder());
        orCancellation.setForeground(Color.decode("#00968b"));
        orCancellation.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
        dummyBtn = orCancellation;
    }//GEN-LAST:event_orCancellationActionPerformed

    private void dcrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcrActionPerformed
        mainSplitPane.setRightComponent(dcrPanel);
        dcrPanel.getAllDCR();
        
        dummyBtn.setForeground(Color.black);
        dummyBtn.setBorder(logoutBtn.getBorder());
        dcr.setForeground(Color.decode("#00968b"));
        dcr.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
        dummyBtn = dcr;
    }//GEN-LAST:event_dcrActionPerformed

    private void orMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orMaintenanceActionPerformed
        mainSplitPane.setRightComponent(ormanMaintenance);
        ormanMaintenance.getOrs();
        
        dummyBtn.setForeground(Color.black);
        dummyBtn.setBorder(logoutBtn.getBorder());
        orMaintenance.setForeground(Color.decode("#00968b"));
        orMaintenance.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
        dummyBtn = orMaintenance;
    }//GEN-LAST:event_orMaintenanceActionPerformed

    private void prepaymentDepositsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prepaymentDepositsActionPerformed
        mainSplitPane.setRightComponent(prepaymentPanel);
        prepaymentPanel.fetchOR();
        
        dummyBtn.setForeground(Color.black);
        dummyBtn.setBorder(logoutBtn.getBorder());
        prepaymentDeposits.setForeground(Color.decode("#00968b"));
        prepaymentDeposits.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
        dummyBtn = prepaymentDeposits;
    }//GEN-LAST:event_prepaymentDepositsActionPerformed

    private void groupPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupPaymentsActionPerformed
        mainSplitPane.setRightComponent(groupPaymentsPanel);
        groupPaymentsPanel.fetchOR();
        
        dummyBtn.setForeground(Color.black);
        dummyBtn.setBorder(logoutBtn.getBorder());
        groupPayments.setForeground(Color.decode("#00968b"));
        groupPayments.setBorder(new LineBorder(Color.decode("#00968b"), 1, true));
        dummyBtn = groupPayments;
    }//GEN-LAST:event_groupPaymentsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bapaPayments;
    private javax.swing.JButton billsPayment;
    private javax.swing.JButton dcr;
    private javax.swing.JButton groupPayments;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton miscellaneousPaymentsMenu;
    private javax.swing.JButton oclPaymentsMenu;
    private javax.swing.JButton orCancellation;
    private javax.swing.JButton orMaintenance;
    private javax.swing.JButton prepaymentDeposits;
    private javax.swing.JMenuItem reprintOR;
    private javax.swing.JLabel serverLabel;
    private javax.swing.JButton serviceConnectionPayments;
    private javax.swing.JButton sumORBtn;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel userIdLabel;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables

    public double getSumOr(List<PaidBills> ors) {
        try {            
            double sum = 0;
            for (int i=0; i<ors.size(); i++) {
                sum += Double.valueOf(ors.get(i).getNetAmount());
            }
            return sum;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public void showClock() {
        try {
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            timeLabel.setText(ObjectHelpers.getCurrentDateDisplay());
                        }
                    });
                }
            });
            timer.setInitialDelay(1);
            timer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
