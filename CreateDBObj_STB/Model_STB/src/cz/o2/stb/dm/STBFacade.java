package cz.o2.stb.dm;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface STBFacade {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    HistoryEven persistHistoryEven(HistoryEven historyEven);

    HistoryEven mergeHistoryEven(HistoryEven historyEven);

    void removeHistoryEven(HistoryEven historyEven);

    List<HistoryEven> getHistoryEvenFindAll();

    HistoryOdd persistHistoryOdd(HistoryOdd historyOdd);

    HistoryOdd mergeHistoryOdd(HistoryOdd historyOdd);

    void removeHistoryOdd(HistoryOdd historyOdd);

    List<HistoryOdd> getHistoryOddFindAll();

    ImageStb persistImageStb(ImageStb imageStb);

    ImageStb mergeImageStb(ImageStb imageStb);

    void removeImageStb(ImageStb imageStb);

    List<ImageStb> getImageStbFindAll();

    Stb persistStb(Stb stb);

    Stb mergeStb(Stb stb);

    void removeStb(Stb stb);

    List<Stb> getStbFindAll();

    Category persistCategory(Category category);

    Category mergeCategory(Category category);

    void removeCategory(Category category);

    List<Category> getCategoryFindAll();

    RegisterFw persistRegisterFw(RegisterFw registerFw);

    RegisterFw mergeRegisterFw(RegisterFw registerFw);

    void removeRegisterFw(RegisterFw registerFw);

    List<RegisterFw> getRegisterFwFindAll();
}
