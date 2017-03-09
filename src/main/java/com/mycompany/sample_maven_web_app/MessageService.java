/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sample_maven_web_app;

import static com.mycompany.sample_maven_web_app.UserService.logger;
import data.Model;
import data.ModelMessages;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import objects.Message;
import objects.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author wlloyd
 */
@Path("messages")
public class MessageService {
    
    static final Logger logger = Logger.getLogger(MessageService.class.getName());

    public MessageService() 
    {
    }
    
    @GET
    @Path("{messageid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(@PathParam("messageid") String id) {
        LinkedList<Message> messageList = new LinkedList<Message>();
     
        try
        {
            int messageid = Integer.parseInt(id);
            Model db = Model.singleton();
            Message[] messages = db.getMessages(messageid);
            if (messageid == 0)
                for (int i=0;i<messages.length;i++)
                    messageList.add(messages[i]);
            else
                messageList.add(messages[0]);
            logger.log(Level.INFO, "Received request to fetch user id=" + messageid);
            return messageList;
        }
        catch (Exception e)
        {
            JSONObject obj = new JSONObject();
                logger.log(Level.WARNING, "Error getting users:" + e.toString());
                return null;
        }

    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateMessage(String jobj) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        Message msg = mapper.readValue(jobj.toString(), Message.class);
        StringBuilder text = new StringBuilder();
        try {
            Model db = Model.singleton();
            int messageid = msg.getMessageId();
            db.updateMessage(msg);
            logger.log(Level.INFO, "update msg with messageid=" + messageid);
            text.append("Message id updated with message id=" + messageid + "\n");
        }
        catch (SQLException sqle)
        {
            String errText = "Error updating user after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
            logger.log(Level.SEVERE, errText);
            text.append(errText);
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Error connecting to db.");
            text.append("Error connecting to db.");
        }
        return text.toString();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteMessage(String jobj) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        Message msg = mapper.readValue(jobj.toString(), Message.class);
        StringBuilder text = new StringBuilder();
        try {
            Model db = Model.singleton();
            int messageid = msg.getMessageId();
            db.deleteMessage(messageid);
            logger.log(Level.INFO, "message deleted from db=" + messageid);
            text.append("Message id deleted with id=" + messageid);
        }
        catch (SQLException sqle)
        {
            String errText = "Error deleteing msg after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
            logger.log(Level.SEVERE, errText);
            text.append(errText);
        }
        catch (Exception e)
        {
            logger.log(Level.SEVERE, "Error connecting to db.");
            text.append("Error connecting to db.");
        }
        return text.toString();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Message> CreateMessage(String jobj) throws IOException 
    {
        
                logger.log(Level.INFO, "RECEIVED CREATE REQUEST FOR:\n");
        logger.log(Level.INFO, "OBJECT:" + jobj + "\n");
        
        LinkedList<Message> lmessage = new LinkedList<Message>();

        ObjectMapper mapper = new ObjectMapper();
        Message message = mapper.readValue(jobj.toString(), Message.class);
        
     
//        if (user.getMessages() != null)
//            for (Object msg : user.getMessages())
//                text.append(msg.toString() + "\n");
        
        try {
            Model db = Model.singleton();
            Message usr = db.newMessage(message);
//            logger.log(Level.INFO, "user persisted to db as userid=" + usr.getUserid());
//            text.append("User id persisted with id=" + usr.getUserid());
            lmessage.add(usr);
        }
        catch (SQLException sqle)
        {
            String errText = "Error persisting user after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
            logger.log(Level.SEVERE, errText);
//            text.append(errText);
        }
        catch (Exception e)
        {
//            logger.log(Level.SEVERE, "Error connecting to db.");
        }
        
        return lmessage;
//        ObjectMapper mapper = new ObjectMapper();
//        Message msg = mapper.readValue(jobj.toString(), Message.class);
//        StringBuilder text = new StringBuilder();
//        
//        try {
//            Model db = Model.singleton();
//            int msgid = db.newMessage(msg);
//            logger.log(Level.INFO, "msg persisted to db with msgid=" + msgid);
//            text.append("Msg id persisted with id=" + msgid);
//        }
//        catch (SQLException sqle)
//        {
//            String errText = "Error persisting user after db connection made:\n" + sqle.getMessage() + " --- " + sqle.getSQLState() + "\n";
//            logger.log(Level.SEVERE, errText);
//            text.append(errText);
//        }
//        catch (Exception e)
//        {
//            logger.log(Level.SEVERE, "Error connecting to db.");
//        }
//        
//        return text.toString();
    }
    
}
