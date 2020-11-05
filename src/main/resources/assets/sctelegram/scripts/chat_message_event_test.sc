__on_chat_message(message, type, entity) ->
    if(message~'^  \n'==null,
        print('  \
__on_chat_message(message, type, entity)\
  - message: ' + replace(message,'\\\n','\\\n                 ') + '\
  - type: ' + type + '\
  - entity: ' + entity)
    )
