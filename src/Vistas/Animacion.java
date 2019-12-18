package Vistas;

import Modelos.ConciliacionPrevia;
import Modelos.Demanda;
import Modelos.Etapa;
import Modelos.ProcesoCivil;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 */
public class Animacion extends javax.swing.JPanel implements Runnable {

    VentanaSimulacion ventana;
    boolean stop = false;
    int x = this.getWidth() / 2;
    int y = this.getHeight() / 2;
    Thread hilo;
    private ProcesoCivil procesoCivil;

    public Animacion() {
        initComponents();
        this.setSize(1560, 810);
        hilo = new Thread(this);
    }

    public void paint(Graphics g) {
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/procesocivil.png"));
        g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillOval(x, y, 15, 15);
    }

    public void inicio(VentanaSimulacion ventana) {
        hilo.start();
        this.ventana = ventana;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new javax.swing.OverlayLayout(this));
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        try {
            procesoCivil = new ProcesoCivil(1);
            ArrayList<Etapa> etapas = procesoCivil.getEtapasProcesoCivil();
            procesoCivil.getMensajesProceso().forEach((a) -> {
                System.out.println(a);
            });
            while (!stop) {
                for (int i = 1; i <= 6; i++) {
                    System.out.println(etapas.size());
                    if (i == 1) {
                        while (x <= ((getWidth() / 6 - 3) * i) - 20) {
                            Thread.sleep(50);
                            x += 5;
                            repaint();
                        }
                        while (y < ((getHeight() / 6 - 7) * i) - 20) {
                            Thread.sleep(50);
                            y += 5;
                            repaint();
                        }

                        if (etapas.size() == 1) {
                            while (y < getHeight() - 20) {
                                Thread.sleep(50);
                                y += 5;
                                repaint();
                            }
                            while (x <= getWidth() - 20) {
                                Thread.sleep(50);
                                x += 5;
                                repaint();
                            }
                            this.stop();
                        }
                    }
                    if (i == 2) {
                        while (x <= ((getWidth() / 6 - 3) * i) - 20) {
                            Thread.sleep(50);
                            x += 5;
                            repaint();
                        }
                        while (y < ((getHeight() / 6 - 7) * i) - 20) {
                            Thread.sleep(50);
                            y += 5;
                            repaint();
                        }
                        if (etapas.size() == 2) {
                            while (y < getHeight() - 20) {
                                Thread.sleep(50);
                                y += 5;
                                repaint();
                            }
                            while (x <= getWidth() - 20) {
                                Thread.sleep(50);
                                x += 5;
                                repaint();
                            }
                            this.stop();
                        }
                    }
                    if (i == 3) {
                        while (x <= ((getWidth() / 6 - 3) * i) - 20) {
                            Thread.sleep(50);
                            x += 5;
                            repaint();
                        }
                        while (y < ((getHeight() / 6 - 7) * i) - 20) {
                            Thread.sleep(50);
                            y += 5;
                            repaint();
                        }
                        if (etapas.size() == 3) {
                            while (y < getHeight() - 20) {
                                Thread.sleep(50);
                                y += 5;
                                repaint();
                            }
                            while (x <= getWidth() - 20) {
                                Thread.sleep(50);
                                x += 5;
                                repaint();
                            }
                            this.stop();
                        }
                    }
                    if (i == 4) {
                        while (x <= ((getWidth() / 6 - 3) * i) - 20) {
                            Thread.sleep(50);
                            x += 5;
                            repaint();
                        }
                        while (y < ((getHeight() / 6 - 7) * i) - 20) {
                            Thread.sleep(50);
                            y += 5;
                            repaint();
                        }
                        if (etapas.size() == 4) {
                            while (y < getHeight() - 20) {
                                Thread.sleep(50);
                                y += 5;
                                repaint();
                            }
                            while (x <= getWidth() - 20) {
                                Thread.sleep(50);
                                x += 5;
                                repaint();
                            }
                            this.stop();
                        }
                    }
                    if (i == 5) {
                        while (x <= ((getWidth() / 6 - 3) * i) - 20) {
                            Thread.sleep(50);
                            x += 5;
                            repaint();
                        }
                        while (y < ((getHeight() / 6 - 7) * i) - 20) {
                            Thread.sleep(50);
                            y += 5;
                            repaint();
                        }
                        if (etapas.size() == 5) {
                            while (y < getHeight() - 20) {
                                Thread.sleep(50);
                                y += 5;
                                repaint();
                            }
                            while (x <= getWidth() - 20) {
                                Thread.sleep(50);
                                x += 5;
                                repaint();
                            }
                            this.stop();
                        }
                    }
                    if (i == 6) {
                        while (x <= ((getWidth() / 6 - 3) * i) - 20) {
                            Thread.sleep(50);
                            x += 5;
                            repaint();
                        }
                        while (y < ((getHeight() / 6 - 7) * i) - 20) {
                            Thread.sleep(50);
                            y += 5;
                            repaint();
                        }
                        if (etapas.size() == 6) {
                            while (y < getHeight() - 20) {
                                Thread.sleep(50);
                                y += 5;
                                repaint();
                            }
                            while (x <= getWidth() - 20) {
                                Thread.sleep(50);
                                x += 5;
                                repaint();
                            }
                            this.stop();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void stop() {
        this.stop = true;
        this.mostrarResultados();
    }

    public void mostrarResultados() {
        String titulo = "Resultados Proceso Civil";
        ArrayList<Etapa> etapas = this.procesoCivil.getEtapasProcesoCivil();
        try {
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            etapas.forEach((e) -> {
                ds.addValue(e.getDiasTranscurridosEtapa(), e.getNombreEtapa() + " dias transcurridos ", "");
            });
            ds.addValue(this.procesoCivil.getDiasTotalesTranscurridos(), "Total Dias Proceso Civil", "");
            JFreeChart grafica = ChartFactory.createBarChart3D(titulo, "", "", ds, PlotOrientation.HORIZONTAL, true, true, true);
            ChartFrame f = new ChartFrame(" ", grafica);
            f.setSize(1000, 600);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            this.ventana.jButton2.setEnabled(true);
            this.ventana.jButton3.setEnabled(true);
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    public ProcesoCivil getProcesoCivil() {
        return this.procesoCivil;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
