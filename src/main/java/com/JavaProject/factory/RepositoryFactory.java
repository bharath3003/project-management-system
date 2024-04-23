package com.JavaProject.factory;
import com.JavaProject.repository.UserRepo;
import com.JavaProject.repository.ProjectRepository;
import com.JavaProject.repository.RequestsRepo;
public abstract interface RepositoryFactory {


    UserRepo createUserRepo();
    RequestsRepo createRequestsRepo();
    ProjectRepository createProjectRepo();

}
