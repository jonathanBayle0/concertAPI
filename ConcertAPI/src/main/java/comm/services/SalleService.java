package comm.services;

import comm.dtos.SalleDto;

import java.util.List;


public interface SalleService {
    SalleDto saveSalle(SalleDto SalleDto);

    SalleDto getSalleById(Long SalleId);

    boolean deleteSalle (Long SalleId);

    List<SalleDto> getAllSalles();
}