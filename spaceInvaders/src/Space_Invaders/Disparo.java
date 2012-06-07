/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Space_Invaders;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class Disparo
{
    private Invasores invasores;
    private boolean disparo=false;
    private int anchoDisparo = 10;
    private int altoDisparo = 25;
    private int posicionDisparoX;
    private int posicionDisparoY;
    private int correcionDisparoX;
    private Color color = Color.GREEN;
    private Colisiones colisiones;
    private boolean poder[];
    private Image disparo1;
    private Image disparo2;
    private Image disparo3;
    private sofia sofia = new sofia(); 
    private int cantidad=0;

    Disparo(Invasores invasores, Colisiones colisiones, int correcionDisparoX)
    {
        this.invasores = invasores;
        this.colisiones = colisiones;
        this.correcionDisparoX = correcionDisparoX;
        init();
        resetDisparo();
    }

    public void init()
    {
        sofia.connectDB();
        disparo1= Toolkit.getDefaultToolkit().createImage(sofia.get_poderesImagen(1));
        disparo2= Toolkit.getDefaultToolkit().createImage(sofia.get_poderesImagen(2));
        disparo3= Toolkit.getDefaultToolkit().createImage(sofia.get_poderesImagen(3));
    }

    public boolean getDisparo()
    {
        return disparo;
    }

    public void setCantidad()
    {
        if(cantidad>0) --cantidad;
    }

    public void initDisparo(int x, int alto)
    {
        disparo=true;
        posicionDisparoX = x;
        posicionDisparoY = alto;
    }

    public void setPoder(int i)
    {
        poder[0]=false;
        poder[1]=false;
        poder[2]=false;
        poder[i]= true;
        cantidad = sofia.get_poderesNivel(i+1);
    }

    public void resetDisparo()
    {
        boolean temp [] = {false,false,false};
        poder =temp;
    }

    public void dibujarDisparo(Graphics2D g)
    {
        g.setColor(color);
        if(disparo && posicionDisparoY >0 && colisiones.getDisparo()!=2)
        {
            if(cantidad>0)
            {
                if(poder[0])
                {
                    g.drawImage(disparo1, posicionDisparoX+10 , posicionDisparoY+20,null);
                    colisiones.setDisparo(posicionDisparoX+10 , posicionDisparoY+20, disparo1.getWidth(null), disparo1.getWidth(null));
                }
                else if(poder[1])
                {
                    g.drawImage(disparo2, posicionDisparoX+10 , posicionDisparoY+20,null);
                    colisiones.setDisparo(posicionDisparoX+10 , posicionDisparoY+20, disparo2.getWidth(null), disparo2.getWidth(null));
                }
                else if(poder[2])
                {
                    g.drawImage(disparo3, posicionDisparoX+10 , posicionDisparoY+20,null);
                    colisiones.setDisparo(posicionDisparoX+10 , posicionDisparoY+20, disparo3.getWidth(null), disparo3.getWidth(null));
                }
            }
            else
            {
                for(int i=0; i<poder.length; ++i) poder[i]=false;
                g.fillRoundRect(posicionDisparoX + correcionDisparoX, posicionDisparoY, anchoDisparo, altoDisparo,5,5);
                g.setColor(Color.BLACK);
                g.drawRoundRect(posicionDisparoX+1 + correcionDisparoX, posicionDisparoY-1, anchoDisparo-1, altoDisparo-1,5,5);
                colisiones.setDisparo(posicionDisparoX + correcionDisparoX, posicionDisparoY, anchoDisparo, altoDisparo);
            }
            posicionDisparoY = posicionDisparoY - invasores.getVDisparoNave();
        }
        else
        {
            disparo = false;
        }
    }

    public boolean tryColision(int posX, int posY, int anchoInvasor, int altoInvasor)
    {
        if(disparo)return colisiones.tryColision(posX, posY, anchoInvasor, altoInvasor);
        return false;
    }
}
