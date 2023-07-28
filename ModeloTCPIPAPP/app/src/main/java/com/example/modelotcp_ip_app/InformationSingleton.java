package com.example.modelotcp_ip_app;

import java.util.LinkedList;

public class InformationSingleton {
    private static InformationSingleton instancia;
    private static int layerLevel;
    private static Layer layer1, layer2, layer3, layer4;
    private static String namePC1, namePC2, nameRouter;
    private static String descriptionPC1, descriptionPC2, descriptionRouter;

    private InformationSingleton() {
    }

    public static InformationSingleton getInstance() {
        if (instancia == null) {
            instancia = new InformationSingleton();
            generateInformation();
        }
        return instancia;
    }

    //GET Y SET NIVEL CAPA
    public static int getLayerLevel() {
        return layerLevel;
    }

    public static void setLayerLevel(int layerLevel) {
        InformationSingleton.layerLevel = layerLevel;
    }

    //OBTENER INFORMACION DE LA CLASE
    public static Layer getLayer1() {
        return layer1;
    }

    public static Layer getLayer2() {
        return layer2;
    }

    public static Layer getLayer3() {
        return layer3;
    }

    public static Layer getLayer4() {
        return layer4;
    }
    public static void generateInformation() {
        generateInformationDevices();
        generateInformationLayer1();
        generateInformationLayer2();
        generateInformationLayer3();
        generateInformationLayer4();
    }

    public static void generateInformationDevices() {
        descriptionPC1 = "Dirección IP: 192.168.0.2\n" +
                "Máscara de subred: 255.255.255.0\n" +
                "Gateway: 192.168.0.1\n" +
                "Dirección MAC: AA:BB:CC:11:22:33\n" +
                "Servidor DNS primario: 8.8.8.8\n" +
                "Servidor DNS secundario: 8.8.4.4";
        descriptionPC2 = "Dirección IP: 192.168.0.3\n" +
                "Máscara de subred: 255.255.255.0\n" +
                "Gateway: 192.168.0.1\n" +
                "Dirección MAC: DD:EE:FF:44:55:66\n" +
                "Servidor DNS primario: 8.8.8.8\n" +
                "Servidor DNS secundario: 8.8.4.4";
        descriptionRouter = "Dirección IP: 192.168.0.1\n" +
                "Máscara de subred: 255.255.255.0\n" +
                "Dirección MAC: XX:YY:ZZ:12:34:56";

        namePC1 = "Dell Laptop Alienware";
        namePC2 = "ASUS Laptop ROG Strix";
        nameRouter = "Tp-link Archer AX55 Pro";
    }

    public static void generateInformationLayer1() {
        LinkedList<Device> devices = new LinkedList<>();
        String title = "Capa de enlace de datos (Link Layer): ";
        String description = "Es la capa más baja del modelo TCP/IP y se ocupa de la comunicación entre dispositivos en una red física. Esta capa define cómo los datos se transmiten en el medio de transmisión, como cables Ethernet o redes inalámbricas, y cómo se direccionan los datos para llegar al destinatario correcto en la misma red local.";
        String protocols = "ARP (Address Resolution Protocol).\n" +
                "RARP (Reverse Address Resolution Protocol)\n" +
                "PPP (Point-to-Point Protocol).\n" +
                "Ethernet: Especifica las características físicas y eléctricas de los cables y tarjetas de red en una red local";
        String method = "Los paquetes de datos de la capa de Internet se dividen en tramas más pequeñas.\n" +
                "La capa de acceso a la red agrega encabezados y tráilers a las tramas para formar un \"frame\" que incluye las direcciones físicas de origen y destino, conocidas como direcciones MAC (Media Access Control).\n" +
                "La trama se transmite físicamente a través del medio de red, como cables o conexiones inalámbricas, hacia su destino.";
        devices.add(new Device(namePC1, descriptionPC1));
        devices.add(new Device(namePC2, descriptionPC2));
        devices.add(new Device(nameRouter, descriptionRouter));
        layer1 = new Layer(title, description, protocols, method, devices);
    }

    public static void generateInformationLayer2() {
        LinkedList<Device> devices = new LinkedList<>();
        String title = "Capa de red (Network Layer)";
        String description = "Esta capa se encarga del enrutamiento de los paquetes de datos desde la fuente hasta el destino a través de una o varias redes interconectadas. Aquí es donde los paquetes son dirigidos a través de diferentes dispositivos de red (routers) para encontrar la ruta óptima hacia su destino final. Los protocolos más comunes en esta capa son el Protocolo de Internet (IP) y el Protocolo de Control de Mensajes de Internet (ICMP).";
        String protocols = "IP (Internet Protocol).\n" +
                "ICMP (Internet Control Message Protocol).\n" +
                "IPsec (Internet Protocol Security).\n" +
                "IGMP (Internet Group Management Protocol)\n";
        String method = "Los paquetes de datos de la capa de transporte se entregan a la capa de Internet.\n" +
                "Aquí, el Protocolo de Internet (IP) juega un papel crucial al agregar información de enrutamiento a los paquetes.\n" +
                "IP utiliza la dirección IP de destino para determinar la mejor ruta para enviar los paquetes a través de la red.";
        devices.add(new Device(namePC1, descriptionPC1));
        devices.add(new Device(namePC2, descriptionPC2));
        devices.add(new Device(nameRouter, descriptionRouter));
        layer2 = new Layer(title, description, protocols, method, devices);
    }

    public static void generateInformationLayer3() {
        LinkedList<Device> devices = new LinkedList<>();
        String title = "Capa de transporte (Transport Layer)";
        String description = "La capa de transporte es responsable de la entrega de datos de extremo a extremo y garantiza que la información se transmita sin errores, en el orden correcto y sin duplicados. También se encarga de manejar el control de flujo y la corrección de errores. Los protocolos más conocidos en esta capa son el Protocolo de Control de Transmisión (TCP) y el Protocolo de Datagramas de Usuario (UDP).";
        String protocols = "TCP (Transmission Control Protocol).\n" +
                "UDP (User Datagram Protocol).\n" +
                "UDP (User Datagram Protocol). \n" +
                "ICMP (Internet Control Message Protocol).\n" +
                "FCP (Fibre Channel Protocol).";
        String method = "Los paquetes de datos de la capa de aplicación se entregan a la capa de transporte.\n" +
                "Aquí, el Protocolo de Control de Transmisión (TCP) o el Protocolo de Datagrama de Usuario (UDP) gestionan el proceso de transporte.\n" +
                "TCP proporciona una comunicación confiable y orientada a la conexión, asegurándose de que los paquetes lleguen correctamente y en el orden correcto. UDP, en cambio, es más simple y no garantiza la entrega confiable ni el orden de los paquetes.";
        devices.add(new Device(namePC1, descriptionPC1));
        devices.add(new Device(namePC2, descriptionPC2));
        devices.add(new Device(nameRouter, descriptionRouter));
        layer3 = new Layer(title, description, protocols, method, devices);
    }

    public static void generateInformationLayer4() {
        LinkedList<Device> devices = new LinkedList<>();
        String title = "Capa de aplicación (Application Layer):";
        String description = "Es la capa más alta del modelo TCP/IP y está relacionada con las aplicaciones que utilizamos para interactuar con la red, como navegadores web, clientes de correo electrónico, clientes FTP, etc. Aquí se encuentran los protocolos que permiten a las aplicaciones comunicarse y transferir datos a través de la red.";
        String protocols = "SSH (Secure Shell)\n" +
                "FTP (File Transfer Protocol)\n" +
                "SMTP (Simple Mail Transfer Protocol)\n" +
                "DHCP (Dynamic Host Configuration Protocol)\n" +
                "DNS (Domain Name System)\n" +
                "RIP (Routing Information Protocol)\n" +
                "SNMP (Simple Network Management Protocol)\n" +
                "HTTP (Hypertext Transfer Protocol)";
        String method = "La aplicación que desea enviar el mensaje interactúa con la capa de aplicación del modelo TCP/IP. Puede ser un navegador web, cliente de correo electrónico u otra aplicación.\n" +
                "El mensaje se divide en datos más pequeños o secciones llamadas \"paquetes\" (en contraste con segmentos en TCP), listos para ser transmitidos.";
        devices.add(new Device(namePC1, descriptionPC1));
        devices.add(new Device(namePC2, descriptionPC2));
        devices.add(new Device(nameRouter, descriptionRouter));
        layer4 = new Layer(title, description, protocols, method, devices);
    }
}
