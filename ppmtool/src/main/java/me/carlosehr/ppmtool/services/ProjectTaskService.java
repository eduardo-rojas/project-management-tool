package me.carlosehr.ppmtool.services;

import me.carlosehr.ppmtool.domain.Backlog;
import me.carlosehr.ppmtool.domain.ProjectTask;
import me.carlosehr.ppmtool.repositories.BacklogRepository;
import me.carlosehr.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask){
        //Exceptions: Project not found

        //PTs to be added to a specific project, project not null, BL exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier );
        //set the bl to the pt
        projectTask.setBacklog(backlog);
        //project sequence: String, ex. MYIDSQ-2
        Integer BacklogSequence = backlog.getPTSequence();

        //Update the BL SEQUENCE
        BacklogSequence++;

        //add sequence to project task
        projectTask.setProjectSequence(projectIdentifier+ "-" + BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);
        //Initial priority when priority is null
        if(projectTask.getPriority()==0||projectTask.getPriority()==null){
            projectTask.setPriority(3);
        }

        //INITIAL status when status is null
//        if(projectTask.getStatus()=="" || projectTask.getStatus()==null){
//            projectTask.setStatus("TO_DO");
//        }

        return projectTaskRepository.save(projectTask);

    }
}
