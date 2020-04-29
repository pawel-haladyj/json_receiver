package pl.haladyj.wzjsontemplate.converter;

public interface ConvertWz<Model, Dto> {

    Model toModel(Dto dto);
    Dto toDto(Model model);


}
