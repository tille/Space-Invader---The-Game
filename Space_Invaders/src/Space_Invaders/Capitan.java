/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Space_Invaders;


public class Capitan extends javax.swing.JFrame
{

    private int campo=0;
    private sofia sofia;
    public Capitan()
    {
        sofia = new sofia();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(51, 204, 0));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        metodo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        nul();
        campo=0;
    }//GEN-LAST:event_jButton2ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void nul()
    {
        jTextArea1.setText(null);
    }

    private String t;
    private String w;

    private void metodo()
    {
        sofia.connectDB();
        if(campo==0)
        {
            String g = jTextArea1.getText();
            if(g.equalsIgnoreCase("reiniciar"))
            {
                sofia.reiniciar();
            }
            else if(g.equalsIgnoreCase("borrarPosicion"))
            {
                campo=1;
            }
            else if(g.equalsIgnoreCase("insertarPoder"))
            {
                campo=2;
            }
            else if(g.equalsIgnoreCase("actualizarPoder"))
            {
                campo=3;
            }
            else if(g.equalsIgnoreCase("actualizarNombre"))
            {
                campo=4;
            }
            else if (g.equalsIgnoreCase("insertarPosicion"))
            {
                campo=5;
            }
            nul();
        }
        else if(campo==1 )
        {
            try
            {
                campo=0;
                sofia.borrarPosicion(Integer.parseInt(jTextArea1.getText()));
                nul();
            }catch(NumberFormatException e)
            {
                nul();
                campo=0;
            }
        }
        else if (campo==2)
        {
            try
            {
                sofia.insertarPoder(Integer.parseInt(jTextArea1.getText()));
                campo=0;
                nul();
            }catch(NumberFormatException e)
            {
                nul();
                campo=0;
            }
        }
        else if (campo==3)
        {
            try
            {
                sofia.actualizarPoder(Integer.parseInt(jTextArea1.getText()));
                campo=0;
                nul();
            }catch(NumberFormatException e)
            {
                nul();
                campo=0;
            }
        }
        else if (campo==4)
        {
            try
            {
                this.t=jTextArea1.getText();
                //sofia.actualizarNombre(Integer.parseInt(jTextArea1.getText()));
                campo=7;
                nul();
            }catch(NumberFormatException e)
            {
                nul();
                campo=0;
            }
        }
        else if (campo==5)
        {
            try
            {
                this.w= jTextArea1.getText();
                campo=6;
                nul();
            }catch(NumberFormatException e)
            {
                nul();
                campo=0;
            }
        }
        else if (campo==6)
        {
            try
            {
                sofia.insertarPosicion(Integer.parseInt(jTextArea1.getText()) , w);
                campo=0;
                nul();
            }catch(NumberFormatException e)
            {
                nul();
                campo=0;
            }
        }
        else if (campo==7)
        {
            try
            {
                sofia.actualizarNombre(t,Integer.parseInt(jTextArea1.getText()));
                campo=0;
                nul();
            }catch(NumberFormatException e)
            {
                nul();
                campo=0;
            }
        }
    }

}
