/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc365a3;

import csc365a3.spanningTree.Graph;
import csc365a3.spanningTree.Edge;
import csc365a3.spanningTree.Vertex;

import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author danielhiggins
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() throws Exception {
        initComponents();
        this.startup();
    }
    ReviewData[] reviews = new ReviewData[0];
    Business[] businesses = new Business[0];
    HashTable ht;
    String closestBus;
    String mclust;

    Graph gp;
    Stage stag;
    HashTable cht;
    Similarity s = new Similarity();
    Btree bt = new Btree();
    public ArrayList<HashTable> ast = new ArrayList<>();
    ArrayList<HashTable> clusts = new ArrayList<>();
    private static final double Length = 800;
    private static final double Width = 1000;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        title = new javax.swing.JLabel();
        csc365 = new javax.swing.JLabel();
        entity = new javax.swing.JLabel();
        similarEntity = new javax.swing.JLabel();
        findSimilarBusiness = new javax.swing.JButton();
        businessTypedIn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        displayMap = new javax.swing.JButton();
        graphButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setText("Dan Higgins");

        csc365.setText("csc365");

        entity.setText("Type a Business");

        similarEntity.setText("Similar Entity:");

        findSimilarBusiness.setText("Find Similar");
        findSimilarBusiness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findSimilarBusinessActionPerformed(evt);
            }
        });

        businessTypedIn.setText("Stephen Szabo Salon");
        businessTypedIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessTypedInActionPerformed(evt);
            }
        });

        jLabel1.setText("Cluster:");

        displayMap.setText("Display Map");
        displayMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayMapActionPerformed(evt);
            }
        });

        graphButton.setText("Graph");
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(similarEntity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(graphButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(title))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(csc365))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(businessTypedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(entity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(findSimilarBusiness))
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(displayMap)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(csc365)
                .addGap(54, 54, 54)
                .addComponent(businessTypedIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entity)
                    .addComponent(findSimilarBusiness))
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(displayMap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(similarEntity)
                        .addGap(21, 21, 21))
                    .addComponent(graphButton, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findSimilarBusinessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findSimilarBusinessActionPerformed
        closestBus = "";
        similarEntity.setText("Similar Entity:");
        String busTyp = businessTypedIn.getText();
        String bid = "";
        int hash = 0;
        for (Business d : businesses) {
            if (busTyp.trim().equalsIgnoreCase(d.getName().trim())) {
                bid = d.getBusId();
                hash = Math.abs(bid.hashCode());
                break;
            }
        }
        Integer answer = null;
        try {
            answer = bt.search(bt.root, hash);
            //System.out.println(answer);
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (answer != null) {

            HashTable goal = null;
            ArrayList<HashTable> zz = new ArrayList<>();
            File nf = new File("src//data");

            File[] lis = nf.listFiles();

            System.out.println("\n\n");
            System.out.println("Finding similar business...");
            for (int i = 0; i < lis.length; i++) {

                //System.out.println("Files " + i+lis[i].toString());
                try {
                    FileInputStream fis = new FileInputStream(lis[i]);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    HashTable teo = (HashTable) ois.readObject();
                    ois.close();

                    if (busTyp.equalsIgnoreCase(teo.bdata.getName())) {//user enters
                        goal = teo;

                    } else {
                        zz.add(teo);
                    }
                } catch (Exception e) {
                    //e.printStackTrace();
                }

            }

            double closest = 0.0;
            double result = 0.0;
            try {

                for (HashTable e : zz) {

                    result = s.cosine(goal, e);
                    //System.out.println("Cosine " + result);
                    if (result > closest) {
                        closest = result;
                        closestBus = e.bdata.getName();
                        mclust = e.bdata.cluster;
                    }

                }
            } catch (Exception e) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, e);
            }

            jLabel1.setText("Cluster: " + mclust);
            System.out.println("Found Similar Business");
            similarEntity.setText("Similar Entity: " + closestBus);

        } else {
            System.out.println("Type real business");
            similarEntity.setText("Similar Entity: Please type a real business");
        }

    }//GEN-LAST:event_findSimilarBusinessActionPerformed

    private void businessTypedInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_businessTypedInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_businessTypedInActionPerformed

    private void displayMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayMapActionPerformed
        String bus = businessTypedIn.getText();

        String businessName = "";
        String clusterh = "";

        for (Business d : businesses) {
            if (bus.trim().equalsIgnoreCase(d.getName().trim())) {
                businessName = d.getName();
                clusterh = d.cluster;

                break;
            }

        }
        int c = 0;
        for (HashTable e : ast) {
            if (bus.trim().equalsIgnoreCase(e.bdata.getName().trim())) {
                this.calculate(gp.getVertex(c));
            }
            c++;
        }
        for (Vertex v : gp.getVertices()) {
            if (v.nameNam().trim().equalsIgnoreCase(clusterh)) {
                System.out.print("Vertex - " + v.nameNam() + " , Dist - " + v.minDistance + " , Cluster head: " + clusterh + "  " + "Path - ");
                for (Vertex vpath : v.path) {
                    System.out.print(" " + vpath.nameNam() + ", ");

                }
                System.out.println(" " + v.nameNam());
            }
        }


    }//GEN-LAST:event_displayMapActionPerformed

    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed
        // no action performed yet.

    }//GEN-LAST:event_graphButtonActionPerformed

    void startup() throws FileNotFoundException, Exception {

        JSONObject obj;

        String reviewFile = "review.json";
        String businessFile = "business.json";

        // This will reference one line at a time
        String line = null;
        try {

            FileReader busReader = new FileReader(businessFile);
            FileReader bReader = new FileReader(reviewFile);

            BufferedReader bufbReader = new BufferedReader(busReader);
            BufferedReader buffReader = new BufferedReader(bReader);
            int c = 0;
            System.out.println("Loading Businesses and Reviews...");
            while ((line = bufbReader.readLine()) != null && c <= 4000) {
                obj = (JSONObject) new JSONParser().parse(line);
                Business d = new Business((String) obj.get("business_id"), (String) obj.get("name"), (String) obj.get("state"), (double) obj.get("latitude"), (double) obj.get("longitude"));                //System.out.println(c);
                businesses = addProduct(businesses, d);
                c++;
            }
            int count = 0;
            while ((line = buffReader.readLine()) != null && count <= 90000) {
                obj = (JSONObject) new JSONParser().parse(line);
                ReviewData rd = new ReviewData((String) obj.get("review_id"), (String) obj.get("business_id"), (String) obj.get("text"));
                //System.out.println(rd.getReview());
                reviews = addReview(reviews, rd);
                count++;
                //System.out.println(count);

            }
            System.out.println("Businesses and Reviews loaded successfully");

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + businessFile + " or " + reviewFile);
        } catch (IOException ex) {
            System.out.println("Error reading file ");
            // Or we could just do this: 
            // ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String cid = "";

        for (Business db : businesses) {

            cid = db.getBusId();
            cht = new HashTable(db);
            for (ReviewData r : reviews) {
                if (cid.trim().equalsIgnoreCase(r.getBusId())) {

                    String text = r.getReview();
                    Scanner kb = new Scanner(text);
                    while (kb.hasNext()) {
                        String word = kb.next();
                        Word wo = new Word(word, 1);
                        //add words to comparing ht
                        cht.put(word, wo);
                    }

                }

            }
            if (!cht.getAll().isEmpty()) {
                ast.add(cht);
            }
        }
        gp = new Graph(ast.size(), ast);
        System.out.println("Making clusters");
        //System.out.println(ast.size());
        //System.out.println("Finding closest businesses (based in location)");

        //int coun = 0;
        for (HashTable db : ast) {
            HashMap<Double, String> od = new HashMap<>();
            //int doun = 0;
            for (HashTable tb : ast) {
                if (!db.bdata.getName().equalsIgnoreCase(tb.bdata.getName())) {

                    double dist = Haversine.distance(db.bdata.getLat(), db.bdata.getLong(), tb.bdata.getLat(), tb.bdata.getLong());
                    od.put(dist, tb.bdata.getName());
                    //System.out.println(db.hashCode()+ " " + tb.hashCode() + " " + dist);
                    //gp.addEdge(coun, doun, dist);

                }
                //doun++;
            }
            //coun++;

            Set<Double> sorted = new TreeSet<>(od.keySet());
            Object[] f = sorted.toArray();

            for (int i = 0; i <= 3; i++) {
                String bus = od.get(f[i]);
                db.bdata.closest[i] = bus;
            }

            //System.out.println(db.bdata.name + ", " + db.bdata.closest[0] + " , " + db.bdata.closest[1] +  ", " + db.bdata.closest[2]);
        }

        int coun = 0;
        for (HashTable db : ast) {
            int doun = 0;
            for (HashTable tb : ast) {
                if (!db.bdata.getName().equalsIgnoreCase(tb.bdata.getName())) {
                    for (int i = 0; i < db.bdata.closest.length; i++) {
                        if (db.bdata.closest[i].equalsIgnoreCase(tb.bdata.getName())) {
                            double dis = Haversine.distance(db.bdata.getLat(), db.bdata.getLong(), tb.bdata.getLat(), tb.bdata.getLong());
                            gp.addEdge(coun, doun, dis);

                        }
                    }
                    doun++;
                }
            }
            coun++;

        }

        HashTable c1 = ast.get(90);
        HashTable c2 = ast.get(554);
        HashTable c3 = ast.get(92);
        HashTable c4 = ast.get(197);
        HashTable c5 = ast.get(309);

        clusts.add(c1);
        clusts.add(c2);
        clusts.add(c3);
        clusts.add(c4);
        clusts.add(c5);

        Cluster c = new Cluster(clusts);
        for (HashTable u : clusts) {
            c.clustData(u);
        }
        for (HashTable r : ast) {
            c.clustData(r);
        }
        ArrayList<String> af = new ArrayList<>();
        System.out.println("Loading...");
        try {

            File f = new File("src//data");
            String[] t = f.list();
            for (int i = 0; i < t.length; i++) {
                af.add(t[i]);
            }

            for (HashTable e : ast) {

                String id = e.bdata.id;

                int hob = id.hashCode();
                int ahob = Math.abs(hob);
                String a = Integer.toString(ahob);
                if (!af.contains(a)) {
                    FileOutputStream fos = new FileOutputStream("src//data//" + ahob, false);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(e);
                    oos.close();
                    af.add(a);
                }
            }

        } catch (FileNotFoundException e) {

        }

        System.out.println("Loading Btree");
        for (HashTable g : ast) {
            String id = g.bdata.id;
            int hob = id.hashCode();
            int ahob = Math.abs(hob);
            bt.insert(ahob);
        }
        FileOutputStream fos = new FileOutputStream("src//treedata//btree", false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(bt);
        //oos.reset();
        oos.close();

        System.out.println("Btree made");

    }

    private static Business[] addProduct(Business[] businesses, Business bToAdd) {
        Business[] newBusiness = new Business[businesses.length + 1];
        System.arraycopy(businesses, 0, newBusiness, 0, businesses.length);
        newBusiness[newBusiness.length - 1] = bToAdd;

        return newBusiness;
    }

    private static ReviewData[] addReview(ReviewData[] rev, ReviewData rToAdd) {
        ReviewData[] newReview = new ReviewData[rev.length + 1];
        System.arraycopy(rev, 0, newReview, 0, rev.length);
        newReview[newReview.length - 1] = rToAdd;

        return newReview;
    }

    public void calculate(Vertex source) {

        source.minDistance = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(source);

        while (!queue.isEmpty()) {

            Vertex u = queue.poll();

            for (Edge neighbour : u.neighbours) {
                Double newDist = u.minDistance + neighbour.weight; //look at neighbor distances

                if (neighbour.target.minDistance > newDist) {

                    queue.remove(neighbour.target); // Remove  node / update the distance value.
                    neighbour.target.minDistance = newDist;

                    neighbour.target.path = new LinkedList<>(u.path);
                    neighbour.target.path.add(u);

                    queue.add(neighbour.target);        //add node with new distance
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);

                } catch (Exception ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField businessTypedIn;
    private javax.swing.JLabel csc365;
    private javax.swing.JButton displayMap;
    private javax.swing.JLabel entity;
    private javax.swing.JButton findSimilarBusiness;
    private javax.swing.JButton graphButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel similarEntity;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
