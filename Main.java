/*
Author: AJ Bridges
Version: 0.0
Date: 2019/10/1
Type: Network Storage Backup Utility
Dependencies: rSync
*/
public class Main {
    public static void main(String[] args) {

        // Process Routines configuration File
        ConfiguredRoutines routines = new ConfiguredRoutines();

        // Pass routines to que Positive Jobs
        JobQue que = new JobQue(routines);

        // rSync any networked servers that have pending jobs
        Sync rSync = new Sync();
        rSync.sync(que.que);

    }
}