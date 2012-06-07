package Space_Invaders;

import java.awt.Color;
import java.awt.Graphics2D;

public class DisparoInvasor
{
    private int disparo=0;
    private int anchoDisparo = 10;
    private int altoDisparo = 25;
    private int posicionDisparoX;
    private int posicionDisparoY;
    private Color color = Color.WHITE;
    private Colisiones colisiones;
    private int vDisparoInvasor;
    private int mundoAlto;


    DisparoInvasor(Colisiones colisiones, int vDisparoNave, int alto)
    {
        this.colisiones = colisiones;
        vDisparoInvasor = vDisparoNave/4;
        mundoAlto = alto;
    }

    public int getDisparo()
    {
        return disparo;
    }

    public void initDisparo(int x, int alto)
    {
        disparo=1;
        posicionDisparoX = x;
        posicionDisparoY = alto;
    }
    
    public boolean dibujarDisparo(Graphics2D g)
    {
        boolean r = false;
        if(disparo==1 && posicionDisparoY+32 < mundoAlto)
        {
            if( !colisiones.tryColision(posicionDisparoX, posicionDisparoY , anchoDisparo, altoDisparo))
            {
                g.setColor(Color.WHITE);
                g.fillRoundRect(posicionDisparoX+22 , posicionDisparoY+32, anchoDisparo, altoDisparo,5,5);
                posicionDisparoY = posicionDisparoY + vDisparoInvasor;
            }
            else
            {
                disparo = 0;
                r= true;
            }
        }else disparo=0;
        return r;
    }

    public boolean tryColision(int posX, int posY, int anchoInvasor, int altoInvasor)
    {
        //if(disparo==1)return colisiones.tryColision(posX, posY, anchoInvasor, altoInvasor);
        return false;
    }

    public void colisionesSetDisparo(int naveX,int naveY,int naveAncho ,int naveAlto)
    {
        colisiones.setDisparo(naveX, naveY, naveAncho , naveAlto);
    }

    public void setVDisparoInvasor(int vDisparoInvasor)
    {
        this.vDisparoInvasor = vDisparoInvasor/4;
    }

    public int getVDisparoInvasor()
    {
        return vDisparoInvasor;
    }
}
