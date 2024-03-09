package ejercicio2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProductorSolicitudes {
    private final static String COLA_SOLICITUDES = "cola_solicitudes";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(COLA_SOLICITUDES, false, false, false, null);

            String solicitud = "Solicitud de soporte técnico: problema con equipo X";
            channel.basicPublish("", COLA_SOLICITUDES, null, solicitud.getBytes());
            System.out.println("Solicitud enviada a la cola: '" + solicitud + "'");
        }
    }
}