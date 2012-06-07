package Space_Invaders;


public class Panel extends javax.swing.JPanel
{
    private Juego juego;
    private int nNave=0;
    private sofia sofia = new sofia();

    Panel(Juego juego)
    {
        initComponents();
        this.juego = juego;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        velocidad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        poder = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        disparo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(700, 70));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setText("Nombre");
        jLabel1.setFocusable(false);
        add(jLabel1);
        jLabel1.setBounds(410, 600, 60, 20);

        jFormattedTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jFormattedTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        jFormattedTextField1.setForeground(new java.awt.Color(51, 204, 0));
        jFormattedTextField1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });
        add(jFormattedTextField1);
        jFormattedTextField1.setBounds(490, 600, 539, 22);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jButton1.setForeground(new java.awt.Color(51, 204, 0));
        jButton1.setText("JUGAR");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(1070, 600, 87, 22);

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jButton2.setForeground(new java.awt.Color(51, 204, 0));
        jButton2.setText("Capitan");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(240, 600, 116, 22);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jButton3.setForeground(new java.awt.Color(51, 204, 0));
        jButton3.setText("Cerrar");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        jButton3.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(110, 600, 116, 22);

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jButton4.setForeground(new java.awt.Color(51, 204, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Space_Invaders/Imagenes/nave1Inicio.png"))); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(620, 130, 116, 131);

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jButton5.setForeground(new java.awt.Color(51, 204, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Space_Invaders/Imagenes/nave3Inicio.png"))); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5);
        jButton5.setBounds(1060, 130, 116, 131);

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jButton6.setForeground(new java.awt.Color(51, 204, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Space_Invaders/Imagenes/nave2Inicio.png"))); // NOI18N
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6);
        jButton6.setBounds(840, 130, 116, 131);

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jLabel2.setText("ELIGE TU VEHICULO DE COMBATE");
        jLabel2.setFocusable(false);
        add(jLabel2);
        jLabel2.setBounds(770, 60, 224, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel4.setForeground(new java.awt.Color(0, 204, 0));
        jLabel4.setText("     Start TX-300");
        jLabel4.setFocusable(false);
        add(jLabel4);
        jLabel4.setBounds(840, 280, 117, 20);

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jButton7.setForeground(new java.awt.Color(51, 204, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Space_Invaders/Imagenes/nave1Inicio.png"))); // NOI18N
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        jButton7.setContentAreaFilled(false);
        add(jButton7);
        jButton7.setBounds(620, 130, 116, 131);

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jButton8.setForeground(new java.awt.Color(51, 204, 0));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Space_Invaders/Imagenes/nave3Inicio.png"))); // NOI18N
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        jButton8.setContentAreaFilled(false);
        add(jButton8);
        jButton8.setBounds(1060, 130, 116, 131);

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jButton9.setForeground(new java.awt.Color(51, 204, 0));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Space_Invaders/Imagenes/nave2Inicio.png"))); // NOI18N
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        jButton9.setContentAreaFilled(false);
        add(jButton9);
        jButton9.setBounds(840, 130, 116, 131);

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel6.setForeground(new java.awt.Color(0, 204, 0));
        jLabel6.setText("ELIGE TU VEHICULO DE COMBATE");
        jLabel6.setFocusable(false);
        add(jLabel6);
        jLabel6.setBounds(770, 60, 224, 20);

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel8.setForeground(new java.awt.Color(0, 204, 0));
        jLabel8.setText("     Start TX-300");
        jLabel8.setFocusable(false);
        add(jLabel8);
        jLabel8.setBounds(840, 280, 117, 20);

        jLabel9.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel9.setForeground(new java.awt.Color(51, 204, 0));
        jLabel9.setText("    Storm STY-A2");
        jLabel9.setFocusable(false);
        add(jLabel9);
        jLabel9.setBounds(1060, 280, 117, 20);

        jLabel10.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel10.setForeground(new java.awt.Color(0, 204, 0));
        jLabel10.setText("  Falcon XFG-321");
        jLabel10.setFocusable(false);
        add(jLabel10);
        jLabel10.setBounds(620, 280, 117, 20);

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 15));
        jTextArea1.setForeground(new java.awt.Color(51, 153, 0));
        jTextArea1.setRows(5);
        jTextArea1.setText("\n    \n      Mision Invasores Espaciales:\n\n      Tu mision si decides aceptarla es la\n\n      de salvar la tierra de los malvados\n\n      invasores que intentan tomar sus\n\n      recursos.\n\n      Eres la ultima esperanza de la  tierra.\n\n      Pero no temas has sido por ser el mejor\n\n      y como el mejor  podras elegir el mejor\n\n      vehiculo de combate.       \n\n      Recuerda la tierra depende de TI. \n\n\n      Cambio y fuera.");
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 0)));
        add(jTextArea1);
        jTextArea1.setBounds(60, 30, 450, 550);

        jLabel11.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel11.setForeground(new java.awt.Color(0, 204, 0));
        jLabel11.setText("  Falcon XFG-321");
        jLabel11.setFocusable(false);
        add(jLabel11);
        jLabel11.setBounds(620, 280, 117, 20);

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel14.setForeground(new java.awt.Color(0, 204, 0));
        jLabel14.setText("    Storm STY-A2");
        jLabel14.setFocusable(false);
        add(jLabel14);
        jLabel14.setBounds(1060, 280, 117, 20);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SimSun", 1, 18), new java.awt.Color(51, 204, 0))); // NOI18N
        jPanel2.setFocusable(false);
        jPanel2.setFont(new java.awt.Font("SimSun-ExtB", 1, 14));

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel15.setForeground(new java.awt.Color(0, 204, 0));
        jLabel15.setText("Velocidad");
        jLabel15.setFocusable(false);

        velocidad.setFont(new java.awt.Font("MS Reference Specialty", 1, 14));
        velocidad.setForeground(new java.awt.Color(0, 204, 0));
        velocidad.setText("I I I I I I I I I I");
        velocidad.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel7.setForeground(new java.awt.Color(0, 204, 0));
        jLabel7.setText("Poder");
        jLabel7.setFocusable(false);

        poder.setFont(new java.awt.Font("MS Reference Specialty", 1, 14));
        poder.setForeground(new java.awt.Color(0, 204, 0));
        poder.setText("I I I I I");
        poder.setFocusable(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14));
        jLabel12.setForeground(new java.awt.Color(0, 204, 0));
        jLabel12.setText("Velocidad Disparo");
        jLabel12.setFocusable(false);

        disparo.setFont(new java.awt.Font("MS Reference Specialty", 1, 14));
        disparo.setForeground(new java.awt.Color(0, 204, 0));
        disparo.setText("I I I I I I I");
        disparo.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disparo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(velocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(poder, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(velocidad))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(poder, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(disparo))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        add(jPanel2);
        jPanel2.setBounds(640, 340, 550, 200);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        iniciarJuego();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        exit();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setNNave(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setNNave(1);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        setNNave(2);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jFormattedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Capitan capitan = new Capitan();
        capitan.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel disparo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel poder;
    private javax.swing.JLabel velocidad;
    // End of variables declaration//GEN-END:variables

    private void exit()
    {
        System.exit(0);
    }

    private void iniciarJuego() {
        try
        {
            if(!jFormattedTextField1.getText().isEmpty())
            {
                juego.setNombre(jFormattedTextField1.getText());
                juego.setNNave(nNave);
                juego.reset(true);
                this.setVisible(false);
            }
        }catch(Exception e){}
    }

    private void setNNave(int n)
    {
        nNave=n;
        if(n==0) setEstado("I I I I I I I I I I","I I I I I","I I I I I I I");
        if(n==1) setEstado("I I I I I I ","I I I I I ","I I I I I I I I I I");
        if(n==2) setEstado("I I I I I I ","I I I I I I I I I I","I I I I I I");
    }

    private void setEstado(String a, String b, String c)
    {
        velocidad.setText(a);
        poder.setText(b);
        disparo.setText(c);
    }
}
