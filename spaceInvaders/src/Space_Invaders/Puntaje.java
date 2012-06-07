package Space_Invaders;


public class Puntaje
{
    private int puntaje;
    private boolean gameOver = false;
    private boolean nextLevel = false;
    private int vidas;

    Puntaje(int nNave)
    {
        sofia sofia = new sofia();
        sofia.connectDB();
        vidas = sofia.get_personajeVidas( nNave +1);

    }

    public int getPuntaje()
    {
        return puntaje;
    }

    public void sumarPuntaje(int suma)
    {
        /*
         * los aliens dan mas puntos segun mas alto se encuentran
         * los muros quitan 50 puntos
         */
        if(puntaje + suma>0) puntaje = puntaje + suma;
        else puntaje = 0;
    }

    public void setGameOver()
    {
        --vidas;
        if(vidas==0) gameOver = true;
    }

    public boolean getGameOver()
    {
        return gameOver;
    }

    public void setNextLevel()
    {
        nextLevel = true;
    }

    public void ganarVida()
    {
        if(vidas<=3) ++vidas;
    }

    public int getVida()
    {
        return vidas;
    }

    public boolean getNextLevel()
    {
        if (nextLevel)
        {
            nextLevel = false;
            return true;
        }
        return false;
    }
}
