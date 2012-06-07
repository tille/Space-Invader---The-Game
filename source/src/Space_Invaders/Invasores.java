package Space_Invaders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

class Invasores
{
    private int invasores1 [][];
    private int invasores2 [][];
    private int invasores3 [][];
    //booleanos
    private boolean fin;
    private boolean pausa;
    private boolean direccion;
    private sofia sofia = new sofia();
    //Imagenes
    private Image invasor1Izq;
    private Image invasor2Izq;
    private Image invasor3Izq;
    private Image invasor1Der;
    private Image invasor2Der;
    private Image invasor3Der;
    //Valor puntaje
    private int puntajeInvasores1 = 200;
    private int puntajeInvasores2 = 150;
    private int puntajeInvasores3 = 100;
    //Variables de posicion
    private int iPosY, iPosX, posY, posX, maxAI, maxBajo, mBajo, maxD;
    private int ancho;
    private int alto;
    private int poderesUsados;
    private int anchoInvasor = 45;
    private int altoInvasor = 32;
    private int contadorAliens=0;
    private int contadorAliens2=0;
    private int vDisparoNave=8;
    private int dInvasor=50;
    private int vNave=6;
    private int time = 3;
    private int vX = 13;
    private int vY = 30;
    private int disY=10;
    private int p = 0;
    //clases
    private Puntaje puntaje;
    private ThreadInvasor th;
    private Disparo [] disparo;
    private Poderes [] poderes;
    private DisparoInvasor [] disparoInvasor = new DisparoInvasor[4];

    public void dibujarDisparoInvasor(Graphics2D g,int x, int y, int ancho, int alto)
    {
        for(int i=0; i<disparoInvasor.length; ++i)
        {
            disparoInvasor[i].colisionesSetDisparo(x, y-30, ancho, alto);
            if(disparoInvasor[i].getDisparo()==1 && disparoInvasor[i].dibujarDisparo(g))  gameOver();
            
        }
    }

    private void gameOver()
    {
        puntaje.setGameOver();
    }

    private void movimientoY()
    {
        if(mBajo < alto-80) posY+=vY;
        else gameOver();
    }

    private void max(int a, int b, int c)
    {
        //determina cual es el invasor que se encuentra mas a la izquierda
        if(a<maxAI) maxAI=a;
        //determina cual es el invasor que se encuentra mas a la derecha
        if(b>maxD) maxD=b;
        //determinan cual es el invasor que se encuentra mas a la abajo
        if(c<maxBajo) maxBajo=c;
        if(c>mBajo) mBajo=c;
    }

    public synchronized void movimiento()
    {
        if (!pausa)
        {
            if(direccion)
            {
                if(maxD+vX<ancho-anchoInvasor) posX += vX;
                else
                {
                    direccion = !direccion;
                    movimientoY();
                }
            }else
            {
                if(maxAI-vX>0) posX -= vX;
                else
                {
                    direccion = !direccion;
                    movimientoY();
                }
            }
        }
    }

    private void dibujarPoderes(int pX, int pY)
    {
        contadorAliens2 =1+contadorAliens2;
        if(contadorAliens2>=15)
        {
            contadorAliens2 = 0;
            poderesUsados = poderesUsados-1;
            for(int i=0; i<poderes.length; ++i) if(poderes[i].nuevoPoder(pX, pY)) i=poderes.length;
        }
    }

    private boolean tryColision(int posX,int posY)
    {
        try
        {
            for(int i=0; i<disparo.length; ++i) if (disparo[0]!=null && disparo[i].tryColision(posX, posY, anchoInvasor, altoInvasor))  return true;
            return false;
        }catch (NullPointerException e)
        {
            return false;
        }
    }

    private void colision(int i, int j)
    {
        if(invasores1[i][j]!=0 && tryColision(posX, posY))
        {
            if(poderesUsados>0)dibujarPoderes(posX, posY);
            invasores1[i][j] = 0;
            puntaje.sumarPuntaje(puntajeInvasores1);
            th.setMinusTme(time);
            nave();
        }
        if(invasores2[i][j] != 0 && tryColision(posX, posY+2*(altoInvasor+disY)))
        {
            if(poderesUsados>0)dibujarPoderes(posX, posY+2*(altoInvasor+disY));
            invasores2[i][j] = 0;
            puntaje.sumarPuntaje(puntajeInvasores2);
            th.setMinusTme(time);
            nave();
        }
        if(invasores3[i][j]!=0 && tryColision(posX, posY +4*(altoInvasor+disY)))
        {
            if(poderesUsados>0)dibujarPoderes(posX, posY +4*(altoInvasor+disY));
            invasores3[i][j] = 0;
            puntaje.sumarPuntaje(puntajeInvasores3);
            th.setMinusTme(time);
            nave();
        }
    }

    private void disparoInvasor(int x, int y)
    {
        for(int i=0; i<disparoInvasor.length; ++i)
        {
            if(disparoInvasor[i].getDisparo()==0)
            {
                disparoInvasor[i].initDisparo(x, y);
                i=disparoInvasor.length;
            }
        }
    }
   
    private void dibujarInvasores(Graphics2D g,Image invasor1, Image invasor2, Image invasor3,  int i , int j)
    {
        int r = (int)((Math.random())*100);
        if(invasores3[i][j]==1)
        {
            fin=false;
            g.drawImage(invasor3,posX, posY +4*(altoInvasor+disY), null);
            max(posX, posX+anchoInvasor, posY +4*(altoInvasor+disY));
            if( r >10 && r < 17 ) disparoInvasor(posX, posY +4*(altoInvasor+disY));
        }
        if(invasores2[i][j]==1)
        {
            fin=false;
            g.drawImage(invasor2,posX, posY+2*(altoInvasor+disY), null);
            max(posX, posX+anchoInvasor, posY+2*(altoInvasor+disY));

            if( r>0 && r < 7) disparoInvasor(posX, posY+2*(altoInvasor+disY));
        }
        if(invasores1[i][j]==1)
        {
            
            fin=false;
            g.drawImage(invasor1, posX, posY, null);
            max(posX, posX+anchoInvasor, posY);
             if( r>93 ) disparoInvasor(posX, posY);
        }
    }

    public void dibujar(Graphics2D g)
    {
        iPosX=posX;
        iPosY=posY;
        fin = true;
        maxAI = Integer.MAX_VALUE;
        maxD = Integer.MIN_VALUE;
        maxBajo = Integer.MAX_VALUE;
        int i;
        int j;
        for( i=0; i<invasores1.length; ++i)
        {
            for(j=0; j<invasores1[0].length; ++j)
            {
                // decteta colisiones entre disparos y invasores y elimina invasores colisionados
                colision(i,j);
                //dibuja los invasores que no han sido eliminados mirando hacia la derecha o izquierda
                if(direccion) dibujarInvasores(g,invasor1Der,invasor2Der,invasor3Der,i,j);
                else dibujarInvasores(g,invasor1Izq,invasor2Izq,invasor3Izq,i,j);
                posX=posX+dInvasor;
            }
            posX = iPosX;
            posY = posY + altoInvasor + disY;
        }
         posX = iPosX;
         posY = iPosY;
         if(fin) setNexLevel();
    }

    Invasores(int ancho, int alto ,Puntaje puntaje, Poderes poderes [])
    {
        init();
        this.ancho = ancho;
        this.alto = alto;
        this.poderes = poderes;
        this.puntaje = puntaje;
        for(int i=0; i<disparoInvasor.length; ++i) disparoInvasor[i] = new DisparoInvasor(new Colisiones(ancho,alto), vDisparoNave, alto);
        anchoInvasor = 45;
        altoInvasor = 32;
        nuevoNivel();
    }

    private void init()
    {
        sofia.connectDB();
        invasor1Izq = Toolkit.getDefaultToolkit().getImage( sofia.get_invasorImagen(1, 1) );
        invasor2Izq = Toolkit.getDefaultToolkit().getImage( sofia.get_invasorImagen(2, 1) );
        invasor3Izq = Toolkit.getDefaultToolkit().getImage( sofia.get_invasorImagen(3, 1) );
        invasor1Der = Toolkit.getDefaultToolkit().getImage( sofia.get_invasorImagen(1, 2) );
        invasor2Der = Toolkit.getDefaultToolkit().getImage( sofia.get_invasorImagen(2, 2) );
        invasor3Der = Toolkit.getDefaultToolkit().getImage( sofia.get_invasorImagen(3, 2) );
    }

    public void nuevoNivel()
    {
        posX=0;
        posY=0;
        direccion = true;
        pausa= false;
        int tInvasores1 [][]= {{1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1}};
        int tInvasores2 [][]= {{1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1}};
        int tInvasores3 [][]= {{1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1}};
        invasores1=tInvasores1;
        invasores2=tInvasores2;
        invasores3=tInvasores3;
        poderesUsados=poderes.length;
        for(int i=0; i<poderes.length; ++i) poderes[i].resetPoder();
    }

    private void nave()
    {
        contadorAliens=contadorAliens+1;
        //cambia la velocidad disparo y la nave
        if(contadorAliens >=16  )
        {
            for(int i=0; i<disparoInvasor.length; ++i) disparoInvasor[i].setVDisparoInvasor(vDisparoNave);
            ++vDisparoNave;
            ++vNave;
            contadorAliens=0;
        }
    }

    //metdos set
    public void setDisparo(Disparo[] disparo)
    {
        this.disparo = disparo;
    }

    public void setPausa(boolean pausa)
    {
        this.pausa = pausa;
    }

    public void setThreadInvasor(ThreadInvasor th)
    {
        this.th = th;
        th.start();
    }

    private void setNexLevel()
    {
        puntaje.setNextLevel();
    }
    
    //metodos get
    public int getVNave()
    {
        return vNave;
    }

    public int getVDisparoNave()
    {
        return vDisparoNave;
    }

    public int getpuntajeInvasores1()
    {
        return puntajeInvasores1;
    }

    public int getpuntajeInvasores2()
    {
        return puntajeInvasores2;
    }

    public int getpuntajeInvasores3()
    {
        return puntajeInvasores3;
    }

    public int getAltoInvasores()
    {
        return altoInvasor;
    }

    public int getAnchoInvasor()
    {
        return anchoInvasor;
    }
}