
import com.rabbitmq.client.*;
    
    public class consumudir {
        private final static String COLA_SOLICITUDES = "cola_solicitudes";
    
        public static void main(String[] args) throws Exception {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
    
            try (Connection connection = factory.newConnection();
                 Channel channel = connection.createChannel()) {
                channel.queueDeclare(COLA_SOLICITUDES, false, false, false, null);
    
                DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                    String solicitud = new String(delivery.getBody(), "UTF-8");
                    System.out.println("Solicitud recibida de la cola: '" + solicitud + "'");
                    System.out.println("Solicitud asignada a un técnico para resolución.");
                };
    
                channel.basicConsume(COLA_SOLICITUDES, true, deliverCallback, consumerTag -> {
                });
            }
        }
    }
import java.nio.channels.Channel;
import java.sql.Connection;


}
