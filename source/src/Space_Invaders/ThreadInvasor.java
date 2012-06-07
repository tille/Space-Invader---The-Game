package Space_Invaders;

class ThreadInvasor extends Thread
{
    private int tiempo=500;
    private Invasores invasores;
    private boolean movimiento=true;

    public void run()
    {
        while(movimiento)
        {
            try
            {
                Thread.sleep(tiempo);
                invasores.movimiento();
            }catch(InterruptedException e){}
        }
    }

    public void parar()
    {
        movimiento = false;
    }

    public void seTiempo(int tiempo)
    {
        this.tiempo = tiempo;
    }

    public void setMinusTme(int t)
    {
        if(tiempo-t>20)  tiempo=tiempo-t;
    }

    public int getTime()
    {
        return tiempo;
    }

    ThreadInvasor(Invasores invasores)
    {
        this.invasores = invasores;
    }

}
