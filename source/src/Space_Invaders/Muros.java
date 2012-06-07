package Space_Invaders;

import java.awt.Color;
import java.awt.Graphics2D;

public class Muros
{
    private int muro1 [][]={{0,3,1,1,1,1,1,1,1,2,0},
                            {3,1,1,1,1,1,1,1,1,1,2},
                            {1,1,1,1,1,1,1,1,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1}};

    private int muro2 [][]={{0,3,1,1,1,1,1,1,1,2,0},
                            {3,1,1,1,1,1,1,1,1,1,2},
                            {1,1,1,1,1,1,1,1,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1}};

    private int muro3 [][]={{0,3,1,1,1,1,1,1,1,2,0},
                            {3,1,1,1,1,1,1,1,1,1,2},
                            {1,1,1,1,1,1,1,1,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1}};

    private int muro4 [][]={{0,3,1,1,1,1,1,1,1,2,0},
                            {3,1,1,1,1,1,1,1,1,1,2},
                            {1,1,1,1,1,1,1,1,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1},
                            {1,1,1,0,0,0,0,0,1,1,1}};

    private Color color = Color.RED;
    private int imagen;
    private int muro1X;
    private int muro2X;
    private int muro3X;
    private int muro4X;
    private int y;
    private int puntajeMuro = -50;
    private Puntaje puntaje;
    private Disparo disparo [];

    Muros(Puntaje puntaje, int anchoMundo)
    {
        this.puntaje = puntaje;
        imagen = anchoMundo/90;
        muro1X =(anchoMundo*29)/100;
        muro2X =(anchoMundo*46)/100;
        muro3X =(anchoMundo*63)/100;
        muro4X =(anchoMundo*79)/100;
    }

    public void setDisparo(Disparo disparo [])
    {
        this.disparo = disparo;
    }

    public void setXY(int x, int y)
    {
        this.y= (y*80)/100;
    }

    private void initMuro(Graphics2D g, int muro[][], int x, int y)
    {
        int ix=x;
        int iy=y;
        for(int i=muro.length-1; i>=0; --i)
        {
            for(int j=muro[0].length-1; j>=0; --j)
            {
                if(muro[i][j]!=0 && tryColision(x, y, imagen))
                {
                    muro[i][j] = 0;
                    puntaje.sumarPuntaje(puntajeMuro);
                }
                if(muro[i][j]==1)
                {
                    g.fillRect(x, y, imagen, imagen);
                }
                else if(muro[i][j]==2)
                {
                    int a [] = {x, x, x+imagen};
                    int b[] = {y+imagen, y, y+imagen};
                    g.fillPolygon(a,b,3);
                }
                else if(muro[i][j]==3)
                {
                    int a [] = {x, x+imagen, x+imagen};
                    int b[] = {y+imagen, y, y+imagen};
                    g.fillPolygon(a,b,3);
                }
                x=x-imagen-1;
            }
            x=ix;
            y=y-imagen-1;
        }
        y=iy;
        x=iy;
    }

    public void dibujar(Graphics2D g)
    {
        g.setColor(color);
        initMuro(g,muro1,muro1X,y);
        initMuro(g,muro2,muro2X,y);
        initMuro(g,muro3,muro3X,y);
        initMuro(g,muro4,muro4X,y);
    }

    private boolean tryColision(int x, int y, int imagen)
    {
        try
        {
            for(int i=0; i<disparo.length; ++i) if (disparo[i].tryColision(x, y, imagen, imagen))  return true;
            return false;
        }catch ( NullPointerException e)
        {
            return false;
        }
    }
}