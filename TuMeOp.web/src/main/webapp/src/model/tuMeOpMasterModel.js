define(['model/_tuMeOpMasterModel'], function() { 
    App.Model.TuMeOpMasterModel = App.Model._TuMeOpMasterModel.extend({

    });

    App.Model.TuMeOpMasterList = App.Model._TuMeOpMasterList.extend({
        model: App.Model.TuMeOpMasterModel
    });

    return  App.Model.TuMeOpMasterModel;

});