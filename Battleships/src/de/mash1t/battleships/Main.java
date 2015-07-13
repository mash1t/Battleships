/*
 * The MIT License
 *
 * Copyright 2015 Manuel Schmid.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.mash1t.battleships;

import de.mash1t.battleships.config.ConfigHelper;
import de.mash1t.battleships.gui.boards.*;
import static de.mash1t.battleships.gui.boards.Board.fieldCountSquare;
import de.mash1t.battleships.gui.helper.DialogHelper;
import de.mash1t.battleships.ships.Ship;
import de.mash1t.battleships.ships.ShipSize;
import de.mash1t.networklib.methods.NetworkBasics;
import de.mash1t.networklib.methods.NetworkProtocolType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 * Main class to start battleships
 *
 * @author Manuel Schmid
 */
public final class Main extends javax.swing.JFrame {

    // Ship List
    private static final List<Ship> shipList = new ArrayList<>();

    // Boards
    private static EnemyBoard enemyBoard;
    private static OwnBoard ownBoard;

    // Helper
    private final DialogHelper dialogHelper = DialogHelper.getDialogHelper(this);

    /**
     * Creates new form Main
     */
    public Main() {
        NetworkBasics.setNetworkProtocolType(NetworkProtocolType.TCP);
        initComponents();
        setLocationRelativeTo(null);
        ConfigHelper.init();
        createShipList();
        startNewGame();
    }

    /**
     * Adds all ships to the shipList
     */
    protected static void createShipList() {
        shipList.add(new Ship(ShipSize.Five));
//        shipList.add(new Ship(ShipSize.Four));
//        shipList.add(new Ship(ShipSize.Four));
//        shipList.add(new Ship(ShipSize.Three));
//        shipList.add(new Ship(ShipSize.Three));
//        shipList.add(new Ship(ShipSize.Three));
//        shipList.add(new Ship(ShipSize.Two));
//        shipList.add(new Ship(ShipSize.Two));
//        shipList.add(new Ship(ShipSize.Two));
//        shipList.add(new Ship(ShipSize.Two));
    }

    /**
     * Resets boards and initializes new game
     */
    public void startNewGame() {
//        switchConnectionPanelState(false);
        enemyBoard = new EnemyBoard(fieldCountSquare, this.pEnemy);
        ownBoard = new OwnBoard(fieldCountSquare, this.pOwn, shipList);
        final JFrame mainFrame = this;
        // Outsource ship placement setter to new thread
        new Thread() {
            @Override
            public void run() {
                // Set up ships
                ownBoard.setShips(shipList);
                
                // Show frame (host or join)
                ConnectionDialog connDialog = new ConnectionDialog(mainFrame);
                connDialog.setLocationRelativeTo(mainFrame);
                connDialog.setVisible(true);
            }
        }.start();
        enemyBoard.disablePanel();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pGame = new javax.swing.JPanel();
        pEnemy = new javax.swing.JPanel();
        pOwn = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(null);
        setMinimumSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(950, 450));

        pGame.setPreferredSize(new java.awt.Dimension(940, 470));

        javax.swing.GroupLayout pEnemyLayout = new javax.swing.GroupLayout(pEnemy);
        pEnemy.setLayout(pEnemyLayout);
        pEnemyLayout.setHorizontalGroup(
            pEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );
        pEnemyLayout.setVerticalGroup(
            pEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pOwnLayout = new javax.swing.GroupLayout(pOwn);
        pOwn.setLayout(pOwnLayout);
        pOwnLayout.setHorizontalGroup(
            pOwnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
        pOwnLayout.setVerticalGroup(
            pOwnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pGameLayout = new javax.swing.GroupLayout(pGame);
        pGame.setLayout(pGameLayout);
        pGameLayout.setHorizontalGroup(
            pGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGameLayout.createSequentialGroup()
                .addComponent(pEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pOwn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pGameLayout.setVerticalGroup(
            pGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pGameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pOwn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pGame, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pEnemy;
    private javax.swing.JPanel pGame;
    private javax.swing.JPanel pOwn;
    // End of variables declaration//GEN-END:variables
}
