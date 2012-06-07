package Space_Invaders;

public class Colisiones
{
    /*
     disparo
        0 - inactivo
        1 - activo
        2 - colisianado
    */
    private int disparo;
    private int disparoAncho;
    private int disparoAlto;
    private int disparoX;
    private int disparoY;
    private int escenario [][];

    public void setDisparo(int disparoX,int disparoY,int disparoAncho ,int disparoAlto)
    {
        for(int i = this.disparoX; i<this.disparoX + this.disparoAncho && i<escenario.length; ++i)
        {
            for(int j=this.disparoY; j<this.disparoY + this.disparoAlto && j<escenario[0].length; ++j)
            {
                if(j> -1) escenario[i][j]=0;
            }
        }
        for(int i = disparoX; i<disparoX + disparoAncho && i<escenario.length; ++i)
        {
            for(int j=disparoY; j<disparoY + disparoAlto && j<escenario[0].length; ++j)
            {
                if(j> -1) escenario[i][j]=1;
            }
        }
        this.disparoAncho = disparoAncho;
        this.disparoAlto = disparoAlto;
        this.disparoX = disparoX;
        this.disparoY = disparoY;
        disparo=1;
    }

    public boolean tryColision(int x, int y, int ancho, int alto)
    {
        if(disparo ==0) return false;
        for(int i=x; i< x + ancho && i<escenario.length; ++i)
        {
            for(int j=y; j< y+alto  && j<escenario[0].length ; ++j)
            {
                if(j> -1 && escenario[i][j] == 1) 
                {
                    disparo=2;
                    return true;
                }
            }
        }
        return false;
    }

    public int getDisparo()
    {
        if(disparo==2)
        {
            disparo=0;
            return 2;
        }
        return disparo;
    }

    Colisiones(int ancho, int alto)
    {
        escenario = new int [ancho][alto];
    }
}