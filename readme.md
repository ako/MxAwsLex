# Mendix AWS Lex connector 

Using this connector you can create a conversional ui using the Amazon Lex service.

Before you can use this connector, you need to train Lex so it will recognize the sentences you will feed it. Please 
consult the AWS documentation to determine how to do this.

## Examples
 
### Get intent

The following example calls AWS Lex to determine the intent of a user utterance.

 ![Determine intent for utterance][1]
 
### Get intent and slots

User utterances can contain parameters or slots. THe following example returns a entities containing the 
intent and any slots that the user specified.

 ![Determine intent and slots for utterance][2]
 
 ![Intent result entities][3]

### Get intent and slots

 [1]: docs/images/mf_determine_intent_for_utterance.png
 [2]: docs/images/mf_determine_intent_slots_for_utterance.png
 [3]: docs/images/lex_result_domain_model.png