package Space_Invaders;

import java.awt.image.BufferStrategy;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Juego extends Canvas
{
    private sofia sofia;
    private KeyListener listener;
    private BufferStrategy strategy;
    //Clases
    private Panel adm;
    private Muros muros;
    private JPanel panel;
    private Puntaje puntaje;
    private Invasores invasores;
    private Disparo [] disparo = new Disparo[3];
    private Poderes poderes [] = new Poderes[3];
    //Colores
    private Color black;
    private Color white;
    //imagenes
    private Image nave;
    private Image invasor1;
    private Image invasor2;
    private Image invasor3;
    private Image fondo;
    //booleanos
    private boolean pausa;
    private boolean gameRunning;
    private boolean inicio;
    private int fin = 0;
    //enteros
    private int x;
    private int time;
    private int alto;
    private int ancho;
    private int level;
    private int nNave;
    private int puntajeAncho;
    private int correcionDisparoX;
    private String nombre;
    private ThreadInvasor th;

    public void setNNave(int nNave)
    {
        if(nNave==0)
        {
            nave = Toolkit.getDefaultToolkit().getImage( sofia.get_personajeImagen(1) );
            correcionDisparoX = -6 + nave.getWidth(null)/2;
        }
        else if(nNave==1)
        {
            nave = Toolkit.getDefaultToolkit().getImage( sofia.get_personajeImagen(2) );
            correcionDisparoX = 26+nave.getWidth(null)/2;
        }
        else
        {
            nave = Toolkit.getDefaultToolkit().getImage( sofia.get_personajeImagen(3) );
            correcionDisparoX =26+nave.getWidth(null)/2;
        }
    }

    private void dibujarPuntajes(Graphics2D g)
    {
        g.setColor(white);
        // variables muy usadas son puestas como variables por cuestiones de legibilidad del codigo
        int tAlto = alto/6;
        int tAncho = ancho + (puntajeAncho/4);
        int tAlto2 = 20 + invasores.getAltoInvasores();
        int tAncho2 = 10 + tAncho + invasores.getAnchoInvasor();
        //doble linea decorativa que separa el fondo del panel de puntajes
        g.drawRect(ancho, 0, 5, alto);
        //dibuja el puntaje total
        g.drawString("Puntaje : "+String.valueOf(puntaje.getPuntaje()), tAncho, tAlto);
        //puntaje de los aliens verde
        g.drawImage(invasor1,tAncho, tAlto2+tAlto, this);
        g.drawString(String.valueOf(invasores.getpuntajeInvasores1()), tAncho2, tAlto2+tAlto+20);
        //puntaje de los aliens rojo
        g.drawImage(invasor2, tAncho, 2*tAlto2 +tAlto, this);
        g.drawString(String.valueOf(invasores.getpuntajeInvasores2()), tAncho2, 2*tAlto2 +tAlto+20);
        //puntaje de los aliens azul
        g.drawImage(invasor3, tAncho, 3*tAlto2 +tAlto, this);
        g.drawString(String.valueOf(invasores.getpuntajeInvasores3()), tAncho2, 3*tAlto2 +tAlto+20);
        //vidas
        g.drawImage(nave, tAncho, 4*tAlto2 +tAlto+20, this);
        g.drawString(" X "+String.valueOf(puntaje.getVida()), tAncho2, 4*tAlto2 +tAlto+20);
    }

    private void dibujarDisparo(Graphics2D g)
    {
        if(disparo[0]!=null) for(int i=0; i<disparo.length; ++i) if(disparo[i].getDisparo()) disparo[i].dibujarDisparo(g);
    }

    public void gameLoop()
    {
        Graphics2D g;
        while (gameRunning)
        {
            g = (Graphics2D) strategy.getDrawGraphics();
            if(inicio && puntaje.getGameOver() && fin !=2)
            {
                g.setColor(Color.WHITE);
                g.drawString("LA TIERRA ESTA PERDIDA", ancho/2, alto/2);
                g.drawString("LA ULTIMA DEFENSA A CAIDO", ancho/2, alto/2+15);
                g.drawString("     FIN DEL JUEGO",ancho/2, alto/2+30);
                g.drawString("Puntaje: "+puntaje.getPuntaje(),ancho/2, alto/2+45);
                g.dispose();
                strategy.show();
                fin=1;
                sofia.insertar(puntaje.getPuntaje(), nombre);
                gameRunning=false;
            }if(fin != 2 && puntaje.getNextLevel())
            {
                ++level;
                if(level<10)
                {
                    g.setColor(Color.WHITE);
                    g.drawString("NIVEL "+level, ancho/2, alto/2);
                    g.dispose();
                    strategy.show();
                    th.seTiempo(sofia.get_velocidadNivel(level));
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    { System.out.println("Error interrupted exception"); }
                    invasores.nuevoNivel();
                }else
                {
                    g.setColor(Color.WHITE);
                    g.drawString("JUEGO SUPERADO", ancho/2, alto/2);
                    g.dispose();
                    strategy.show();
                    gameRunning=false;
                }
            }else if(fin==2)
            {
                g.setColor(Color.WHITE);
                g.drawString("LA TIERRA ESTA A SALVO", ancho/2, alto/2);
                g.drawString("LAS DEFENSAS PREPARAN EL CONTRAATAQUE", ancho/2, alto/2+15);
                g.drawString("     FILICITACIONES",ancho/2, alto/2+30);
                g.drawString("Puntaje: "+puntaje.getPuntaje(),ancho/2, alto/2+45);
                g.dispose();
                strategy.show();
                fin=1;
            }
            else if(!pausa)
            {
                g.setColor(black);
                //g.fillRect(0,0,ancho + puntajeAncho,alto);
                g.drawImage(fondo, 0, 0, this);
                g.fillRect(ancho,0,puntajeAncho,alto);
                dibujarDisparo(g);
                dibujarDisparoInvasores(g);
                for(int i=0,tipo; i<poderes.length; ++i)
                {
                    if( poderes[i].dibujarPoder(g, x, alto-nave.getHeight(null)) )
                    {
                        //los poderes actualizan los datos de disparo
                        tipo=poderes[i].getTipo();
                        if(tipo==0){ for(int j=0; j<disparo.length; ++j) disparo[j].setPoder(0);}
                        if(tipo==1){ for(int j=0; j<disparo.length; ++j) disparo[j].setPoder(1);}
                        if(tipo==2){ for(int j=0; j<disparo.length; ++j) disparo[j].setPoder(2);}
                    }
                }
                //dibujo la nave principal
                g.drawImage(nave, x, alto-nave.getHeight(null), nave.getWidth(null), nave.getHeight(null), this);
                muros.dibujar(g);
                invasores.dibujar(g);
                //dibuja la ventaja de puntajes y los actualiza
                dibujarPuntajes(g);
                //dibuja todo
                g.dispose();
                strategy.show();
            }
            try
            { Thread.sleep(time); }
            catch (InterruptedException e)
            { System.out.println("Error interrupted exception"); }
        }
    }

    private void dibujarDisparoInvasores(Graphics2D g)
    {
        invasores.dibujarDisparoInvasor(g, x, alto-nave.getHeight(null), nave.getWidth(null), nave.getHeight(null));
    }

    public static void main(String arg[])
    {
        Juego j = new Juego();
        j.gameLoop();
    }
    
    Juego()
    {
        sofia = new sofia();
        sofia.connectDB();
        //inicilisa variables y clases
        init();
        reset(false);
        JFrame container = new JFrame("Invasores Espaciales");
        container.setPreferredSize(new Dimension(ancho+puntajeAncho,alto+29));
        panel = (JPanel) container.getContentPane();
        panel.setPreferredSize(new Dimension(ancho+puntajeAncho,alto));
        panel.setLayout(null);
        //se crea el menu inicio
        adm = new Panel(this);
        adm.setVisible(false);
        adm.setBounds(0, 0, ancho+puntajeAncho, alto);
        panel.add(adm);
        // setup our canvas size and put it into the content of the frame
        setBounds(0,0,ancho+puntajeAncho,alto);
        panel.add(this);
        //Icono de la aplicacion
        container.setIconImage(Toolkit.getDefaultToolkit().getImage( sofia.getIcono() ));
        //cerrar ventana
        container.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent we){ System.exit(0); }});
        //se agrega el Key Listener al canvas Juego
        addKeyListener(listener);
        //se hace visible la ventana
        container.pack();
        container.setResizable(false);
        adm.setVisible(true);
        container.setVisible(true);
        //Se crea el Buffer Strategy
        setIgnoreRepaint(true);
        createBufferStrategy(2);
        strategy = getBufferStrategy();
    }

    public void reset(boolean inicio)
    {
        //enteros
        level=1;
        //booleanos
        this.inicio=inicio;
        //clases
        puntaje = new Puntaje(nNave);
        for(int i=0; i<poderes.length; ++i) poderes[i] = new Poderes(ancho,alto,nave.getWidth(null),nave.getHeight(null));
        invasores = new Invasores(ancho,alto,puntaje,poderes);
        muros = new Muros(puntaje,ancho);
        muros.setXY(ancho,alto);
        for(int i=0; i<disparo.length; ++i) disparo[i] = new Disparo(invasores,new Colisiones (ancho,alto), correcionDisparoX);
        invasores.setDisparo(disparo);
        muros.setDisparo(disparo);
        //se inicia el thread que controla el movimiento y velocidad de los invasores
        th = new ThreadInvasor(invasores);
        invasores.setThreadInvasor(th);
        th.seTiempo(sofia.get_velocidadNivel( level ));
    }
    
    private void init() 
    {
      //inicializa:
        //imagenes
        nave = Toolkit.getDefaultToolkit().getImage( sofia.get_personajeImagen( 1 ) );
        invasor1 = Toolkit.getDefaultToolkit().getImage( sofia.get_invasorImagen( 1,2 ) );
        invasor2 = Toolkit.getDefaultToolkit().getImage( sofia.get_invasorImagen( 2,2 ) );
        invasor3 = Toolkit.getDefaultToolkit().getImage( sofia.get_invasorImagen( 3,2 ) );
        fondo = Toolkit.getDefaultToolkit().getImage( sofia.get_escenarioImagen( 1 ) );
        //Colores
        white = Color.WHITE;
        black = Color.BLACK;
        //booleanos
        inicio=false;
        gameRunning = true;
        pausa=false;
        //enteros
        time= 12;
        ancho=1100;
        alto=650;
        puntajeAncho =150;
        x = ancho/2;
        setNNave(0);

        listener = new KeyListener() 
        {
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e)
            { 
                lis(e.getKeyCode()); 
            }
            private void lis (int e)
            {
                if(inicio)
                {
                    switch (e)
                    {
                        case KeyEvent.VK_LEFT :  setXLeft(invasores.getVNave());
                                                 break;
                        case KeyEvent.VK_RIGHT : setXRight(invasores.getVNave());
                                                 break;
                        case KeyEvent.VK_SPACE:  disparo();
                                                 break;
                        case KeyEvent.VK_ENTER:  pausa();
                                                 break;
                        default:                if(fin==0)panel.setVisible(true);
                                                System.out.println("Tecla in valida : "+ e);
                    }
                }
                if(fin==0)
                {
                    panel.setVisible(true);
                }
            }
        };
    }
    
    private void pausa()
    {
        pausa=!pausa;
        invasores.setPausa(pausa);
        if(pausa)
        {
            Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
            g.setColor(white);
            g.drawString("Pause", ancho/2, alto/2);
            g.dispose();
            strategy.show();
        }
    }

    public void disparo()
    {
        if(!pausa)
        {
            boolean b=true;
            for(int i=0; i<disparo.length && b; ++i)
            {
                if(!disparo[i].getDisparo())
                {
                    b=false;
                    disparo[i].initDisparo(x,alto - nave.getHeight(this));
                    for(int j=0; j<disparo.length; ++j)disparo[j].setCantidad();
                }
            }
        }
    }

    public void setXLeft(int i)
    {
       if(!pausa)
       {
           if(x-i > 0) x= x-i;
           else x= 0;
       }
    }

    public void setXRight(int i)
    {
       if(!pausa)
       {
           if(x+i < ancho - nave.getWidth(null) - 13) x = x + i;
           else x = ancho - nave.getWidth(null) - 13;
       }
    }

    void setNombre(String nombre) {
        this.nombre=nombre;
    }
}