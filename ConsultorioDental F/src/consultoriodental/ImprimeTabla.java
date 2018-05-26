/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultoriodental;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author GARCIA ZARATE JORGE MANUEL
 *
 * FECHA : 20 DE OCTUBRE DEL 2017
 */
public class ImprimeTabla extends AbstractTableModel {

    String encabezados[] = new String[]{"NOMBRE PACIENTE", "HORA", "MOTIVO"};

    Class tipos[] = new Class[]{String.class, String.class, String.class};

     ArrayList<Object[]> datos = new ArrayList<Object[]>();

    public ImprimeTabla(){    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return encabezados.length;
    }

    @Override
    public String getColumnName(int colum) {
        return encabezados[colum];
    }

    @Override
    public Class getColumnClass(int colum) {
        return tipos[colum];
    }

    @Override
    public Object getValueAt(int row, int colum) {
       
           return datos.get(row)[colum];
    }
    

    @Override
    public boolean isCellEditable(int row, int colum) {
        return colum == 4;
    }
    public void setCellAt(Object d, int row, int colum){
        if(colum==4){
            datos.get(row)[colum]=d;
        }
    }

    public void setValueAt(Object d, int row, int colum) {
        if (d != null) {
            datos.get(row)[colum] = d;
          
        }
    }

    

}
