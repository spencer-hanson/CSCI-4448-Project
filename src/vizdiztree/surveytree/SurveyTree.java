  
  public int buildTree(){
        try{
                ProcessBuilder pb = new ProcessBuilder("python","decision_tree.py");
            Process p = pb.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            int ret = new Integer(in.readLine()).intValue();
            System.out.println(ret);

        }catch(Exception e){System.out.println(e);}


        return 0;
    }