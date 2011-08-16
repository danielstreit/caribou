(in-ns 'triface.migration)

(defn create-model-model []
  (db/insert
   :model
   {:name "model"
    :slug "model"
    :description "base model for models"
    :position 1
    :nested false
    :locked true
    :abstract false
    :ancestor_id 0}))

(defn create-model-fields []
  (let [model-id ((first (db/query "select id from model where name = 'model'")) :id)]
    (db/insert
     :field
     {:name "id"
      :slug "id"
      :type "integer"
      :model_id model-id})
    (db/insert
     :field
     {:name "name"
      :slug "name"
      :type "string"
      :model_id model-id})
    (db/insert
     :field
     {:name "slug"
      :slug "slug"
      :type "string"
      :model_id model-id})
    (db/insert
     :field
     {:name "description"
      :slug "description"
      :type "text"
      :model_id model-id})
    (db/insert
     :field
     {:name "position"
      :slug "position"
      :type "integer"
      :model_id model-id})
    (db/insert
     :field
     {:name "nested"
      :slug "nested"
      :type "boolean"
      :model_id model-id})
    (db/insert
     :field
     {:name "locked"
      :slug "locked"
      :type "boolean"
      :model_id model-id})
    (db/insert
     :field
     {:name "abstract"
      :slug "abstract"
      :type "boolean"
      :model_id model-id})
    (db/insert
     :field
     {:name "ancestor_id"
      :slug "ancestor_id"
      :type "integer"
      :model_id model-id})
    (db/insert
     :field
     {:name "created_at"
      :slug "created_at"
      :type "timestamp"
      :model_id model-id})
    (db/insert
     :field
     {:name "updated_at"
      :slug "updated_at"
      :type "timestamp"
      :model_id model-id})))

(defn create-field-model []
  (db/insert
   :model
   {:name "field"
    :slug "field"
    :description "a model that specifies what fields a model has"
    :position 2
    :nested false
    :locked true
    :abstract false
    :ancestor_id 0}))

(defn create-field-fields []
  (let [model-id ((first (db/query "select id from model where name = 'field'")) :id)]
    (db/insert
     :field
     {:name "id"
      :slug "id"
      :type "integer"
      :model_id model-id})
    (db/insert
     :field
     {:name "model_id"
      :slug "model_id"
      :type "integer"
      :model_id model-id})
    (db/insert
     :field
     {:name "link_id"
      :slug "link_id"
      :type "integer"
      :model_id model-id})
    (db/insert
     :field
     {:name "name"
      :slug "name"
      :type "string"
      :model_id model-id})
    (db/insert
     :field
     {:name "slug"
      :slug "slug"
      :type "string"
      :model_id model-id})
    (db/insert
     :field
     {:name "type"
      :slug "type"
      :type "string"
      :model_id model-id})
    (db/insert
     :field
     {:name "description"
      :slug "description"
      :type "text"
      :model_id model-id})
    (db/insert
     :field
     {:name "position"
      :slug "position"
      :type "integer"
      :model_id model-id})
    (db/insert
     :field
     {:name "required"
      :slug "required"
      :type "boolean"
      :model_id model-id})
    (db/insert
     :field
     {:name "disjoint"
      :slug "disjoint"
      :type "boolean"
      :model_id model-id})
    (db/insert
     :field
     {:name "singular"
      :slug "singular"
      :type "boolean"
      :model_id model-id})
    (db/insert
     :field
     {:name "locked"
      :slug "locked"
      :type "boolean"
      :model_id model-id})
    (db/insert
     :field
     {:name "created_at"
      :slug "created_at"
      :type "timestamp"
      :model_id model-id})
    (db/insert
     :field
     {:name "updated_at"
      :slug "updated_at"
      :type "timestamp"
      :model_id model-id})))

(def migrate (fn []
  (create-model-model)
  (create-model-fields)
  (create-field-model)
  (create-field-fields)))

