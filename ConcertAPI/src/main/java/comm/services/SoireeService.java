package comm.services;

import comm.dtos.SoireeDto;

import java.util.List;

public interface SoireeService {
    SoireeDto saveSoiree(SoireeDto SoireeDto);

    SoireeDto getSoireeById(Long SoireeId);

    boolean deleteSoiree (Long SoireeId);

    List<SoireeDto> getAllSoiree();
}
