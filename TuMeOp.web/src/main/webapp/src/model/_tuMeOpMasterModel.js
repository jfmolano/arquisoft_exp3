define([], function() {
    App.Model._TuMeOpMasterModel = Backbone.Model.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('tuMeOp-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.TuMeOpModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.tuMeOpEntity,options);
            }
        }
    });

    App.Model._TuMeOpMasterList = Backbone.Collection.extend({
        model: App.Model._TuMeOpMasterModel,
        initialize: function() {
        }

    });
    return App.Model._TuMeOpMasterModel;
    
});