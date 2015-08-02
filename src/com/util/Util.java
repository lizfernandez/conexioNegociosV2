package com.util;


import java.lang.reflect.Field;
import java.util.Random;



public class Util {
	
	
	
	public static String cadenaAlfanumAleatoria (int longitud){
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < longitud){
		   char c = (char)r.nextInt(255);
		   if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
		           cadenaAleatoria += c;
		           i ++;
		         }
		     }
		return cadenaAleatoria;
		}
	public static String dia(int day){
		String monthString;
        switch (day) {
 
            case 1:  monthString = "Domingo";
                     break;
            case 2:  monthString = "lunes";
                     break;
            case 3:  monthString = "Martes";
                     break;
            case 4:  monthString = "Miercoles";
                     break;
            case 5:  monthString = "Jueves";
                     break;
            case 6:  monthString = "Viernes";
                     break;
            case 7:  monthString = "Sabado";
                     break;          
            default: monthString = "Invalid month";
                     break;
        }
		return monthString;
	}
	public static String mes(int mes){
		String monthString;
        switch (mes) {
 
            case 1:  monthString = "Enero";
                     break;
            case 2:  monthString = "Febrero";
                     break;
            case 3:  monthString = "Marzo";
                     break;
            case 4:  monthString = "Abril";
                     break;
            case 5:  monthString = "Mayo";
                     break;
            case 6:  monthString = "Junio";
                     break;
            case 7:  monthString = "Julio";
                     break;  
            case 8:  monthString = "Agosto";
            		 break;  
            case 9:  monthString = "Septiembre";
            		 break;  
            case 10:  monthString = "Octubre";
            		 break;  
            case 11:  monthString = "Noviembre";
            		 break;  
            case 12: monthString = "Diciembre";
            		break;  
            default: monthString = "Invalid month";
                     break;
        }
		return monthString;
	}
	

	
	public static <E> E comparar(Object obj1, Object obj2) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {

		/* System.out.println("type ="+obj2);
		 System.out.println("type getClass = "+obj2.getClass().getName());
		 */
		 E objOrigen =  (E) obj2;
		 E objDestino =  (E) obj1;
		 System.out.println(" E obj= "+objOrigen);
		/// type.get
		//Class obj = Class.forName(type);
		// Class obj =type;
		Field[] fields = objOrigen.getClass().getDeclaredFields();
		
		for (Field f : fields) {

			try {
				String fieldOrigen = f.getName();
				Field fDestino = objDestino.getClass().getDeclaredField(fieldOrigen);
				f.setAccessible(true);
				fDestino.setAccessible(true);
				Object fieldValue = f.get(objOrigen);
				/**/
				if (fieldValue != null) {
					System.out.println("name field =" + fieldOrigen);
					// System.out.println(" Object fieldType = "+f.getType());
					System.out.println("valor field origen= " + fieldValue.toString());
					System.out.println("valor field destino= " + fDestino.get(objDestino));

					if (!fieldValue.toString().equals("0") && !Constantes.CAMPO_SERAILIZABLE.equals(fieldOrigen)) {
						
					fDestino.set(objDestino, fieldValue);
					// f.getType().equals(int);
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// f.set(objOrigen, fieldValue);
			// Field fdestino =

        }
       // E lita = (E) obj1;
		return objDestino;
		
	}
	public static Object emptyInstance(String type) {
        //Este metodo crea una instancia de Class con el tipo
        //de dato obtenido por parametro, y luego itera sobre
        //los Constructores de esta Clase para intentar
        //crear una Instancia en base a un Constructor Vacio
        Object obj = null;
        try {
            Class clazz = Class.forName(type);

            for (java.lang.reflect.Constructor con : clazz.getConstructors()) {
                if (con.getParameterTypes().length == 0) {
                    obj = con.newInstance();
                    break;
                }
            }
        } catch (Exception e) {
            return null;
        }

        return obj;
    }
}
