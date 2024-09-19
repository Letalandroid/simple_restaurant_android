package controllers;

import models.Product;

public class ProductoPlato {

    Product prod;

    public String calcOperation(Product p) {
        String mensaje = "";

        int plato = p.getPlato();
        int cant = p.getNum_plato();
        int costo = costoPlato(p);
        float venta = calcVenta(p);

        prod = new Product();
        prod.setPlato(plato);
        prod.setNum_plato(cant);
        prod.setPrecio(costo);
        prod.setVenta(venta);

        mensaje = "El costo del plato es: " + costo + "\n" +
                "La cantidad de platos es: " + cant + "\n" +
                "La cuenta total es: " + venta;

        return mensaje;
    }

    public int costoPlato(Product p) {
        int costo = 0;

        switch (p.getPlato()) {
            case 0 -> {
                costo = 0;
            }
            case 1 -> {
                costo = 15;
            }
            case 2 -> {
                costo = 25;
            }
            case 3, 4 -> {
                costo = 20;
            }
        }

        return costo;
    }

    public float calcVenta(Product p) {
        float venta = 0;

        venta = costoPlato(p) * p.getPlato();

        return venta;
    }

}
