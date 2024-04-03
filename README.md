# TCP-Chat-Application

### Introduction:
This documentation provides a detailed overview of a TCP chat application implemented in Java using JavaFX for the graphical user interface. The application consists of both server and client components, allowing users to communicate with each other over a TCP/IP network.

### Features:

- `Server Component`: Handles incoming connections from clients, facilitates message exchange, and broadcasts messages to all connected clients.
- `Client Component`: Connects to the server, sends messages, and displays received messages.
- `Graphical User Interface (GUI)`: Implemented using JavaFX to provide an intuitive interface for users to interact with the application.

### Setup Instructions:

1. Prerequisites:
- Java Development Kit (JDK) installed on your system.
- JavaFX SDK installed (included with JDK 8 and later versions).

2. Clone Repository:
- Clone the repository from GitHub: repository-link.
  
3. Compile and Run:
- Compile the server and client Java files using the Java compiler.
- Run the server using the compiled Server class file.
- Run the client using the compiled Client class file.



## Server Component:

### 1. Server.java:

- Initializes a server socket to listen for incoming connections.
- Upon connection from a client, creates a socket and sets up input and output streams.
- Provides methods to send and receive messages to/from the connected client.
- Includes a method to close server resources.

### 2. HelloController.java (Server):

- Initializes the server and sets up event handlers for sending messages.
- Displays messages received from the client in the GUI.

## Client Component:

### 1. Client.java:

- Connects to the server using a socket.
- Sets up input and output streams for communication with the server.
- Provides methods to send and receive messages to/from the server.
- Includes a method to close client resources.

### 2. HelloController.java (Client):

- Initializes the client and sets up event handlers for sending messages.
- Displays messages received from the server in the GUI.

## GUI Design:

### 1. hello-view.fxml:
- Defines the layout and structure of the GUI for both server and client sides.
- Includes input fields, buttons, and message display areas.

## Usage:
- Start the server and one or more clients.
- Enter messages in the input field and click 'send' to send messages.
- Sent messages will be displayed in the message display area.
- Received messages will also be displayed in the message display area.

## Conclusion:
This TCP chat application provides a simple yet effective means of communication over a network. By following the setup instructions and utilizing the provided components, users can establish a chat environment for real-time messaging. The use of JavaFX ensures a user-friendly interface, enhancing the overall experience of the application.

# Output
https://github.com/akhilathuluri/TCP-Chat-Application/assets/89147384/a32626e9-0b3c-424d-b420-e67c23c6e9a2





