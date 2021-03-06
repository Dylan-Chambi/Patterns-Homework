package observer.exercise;

import java.util.HashSet;
import java.util.Set;

public class Client {
    public static void main (String [] args){
        CanalNotificaciones canalNotificaciones = new CanalNotificaciones();
        NotificacionPromocion notificacionPromocion = new NotificacionPromocion("Anual", "Por la compra de tal cosa, recibe un descuento");
        NotificacionPremio notificacionPremio = new NotificacionPremio("Credito Extra","Usted es el ganador del credito extra");
        NotificacionNoticia notificacionNoticia = new NotificacionNoticia("Se ha confirmado una pandemia global de coronavirus");
        NotificacionPrecioLlamada notificacionPrecioLlamada = new NotificacionPrecioLlamada("Se debe llamar solo durante el fin de semana","5Bs");


        Cliente c1 = new Cliente(new Persona("65656065", "Juan"), "123456789");
        canalNotificaciones.attach(c1, Set.of(NotificacionType.PREMIO, NotificacionType.PROMOCION));

        Cliente c2 = new Cliente(new Persona("65656066", "Pedro"), "123456789");
        canalNotificaciones.attach(c2, Set.of(NotificacionType.NOTICIA));

        Cliente c3 = new Cliente(new Persona("65656067", "Carlos"), "123456789");
        canalNotificaciones.attach(c3, Set.of(NotificacionType.PREMIO, NotificacionType.PROMOCION, NotificacionType.NOTICIA, NotificacionType.PRECIO_LLAMADA));

        canalNotificaciones.publishNotification(notificacionPromocion);
        canalNotificaciones.publishNotification(notificacionPremio);
        canalNotificaciones.publishNotification(notificacionNoticia);
        canalNotificaciones.publishNotification(notificacionPrecioLlamada);


        Cliente c4 = new Cliente(new Persona("65656068", "Maria"), "123456789");
        canalNotificaciones.attach(c4, Set.of(NotificacionType.PREMIO, NotificacionType.PROMOCION, NotificacionType.NOTICIA, NotificacionType.PRECIO_LLAMADA));

        NotificacionNoticia notificacionNoticia2 = new NotificacionNoticia("Real Madrid gana la Champions League");
        canalNotificaciones.detach(c3, NotificacionType.NOTICIA);


        canalNotificaciones.publishNotification(notificacionNoticia2);

    }
}